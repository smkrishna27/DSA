package lld.taskscheduler;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

public class TaskScheduler {

    private static class ScheduledTask implements Delayed {
        final String id;
        final Runnable command;
        final long periodMillis; // 0 => one-shot
        volatile long executionTimeMillis;
        volatile boolean cancelled = false;

        ScheduledTask(String id, Runnable command, long executionTimeMillis, long periodMillis) {
            this.id = id;
            this.command = command;
            this.executionTimeMillis = executionTimeMillis;
            this.periodMillis = periodMillis;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = executionTimeMillis - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.executionTimeMillis, ((ScheduledTask) o).executionTimeMillis);
        }
    }

    private final DelayQueue<ScheduledTask> queue = new DelayQueue<>();
    private final Map<String, ScheduledTask> taskIndex = new ConcurrentHashMap<>();
    private final ExecutorService workerPool;
    private final Thread dispatcher;
    private volatile boolean running = true;

    public TaskScheduler(int workerThreads) {
        this.workerPool = Executors.newFixedThreadPool(workerThreads);
        this.dispatcher = new Thread(this::dispatchLoop, "task-scheduler-dispatcher");
        this.dispatcher.setDaemon(true);
        this.dispatcher.start();
    }

    public String schedule(Runnable command, long delayMillis) {
        return scheduleInternal(command, delayMillis, 0);
    }

    public String scheduleAtFixedRate(Runnable command, long initialDelayMillis, long periodMillis) {
        return scheduleInternal(command, initialDelayMillis, periodMillis);
    }

    private String scheduleInternal(Runnable command, long delayMillis, long periodMillis) {
        String id = UUID.randomUUID().toString();
        long execTime = System.currentTimeMillis() + delayMillis;
        ScheduledTask task = new ScheduledTask(id, command, execTime, periodMillis);
        taskIndex.put(id, task);
        queue.put(task);
        return id;
    }

    public boolean cancel(String taskId) {
        ScheduledTask task = taskIndex.remove(taskId);
        if (task != null) {
            task.cancelled = true;
            return true;
        }
        return false;
    }

    private void dispatchLoop() {
        while (running) {
            try {
                ScheduledTask task = queue.take(); // blocks until a task is due
                if (task.cancelled) continue;

                workerPool.submit(() -> {
                    try {
                        task.command.run();
                    } catch (Exception e) {
                        // log and continue; a failing task must not kill the pool
                    }
                });

                if (task.periodMillis > 0 && !task.cancelled) {
                    task.executionTimeMillis = System.currentTimeMillis() + task.periodMillis;
                    queue.put(task);
                } else {
                    taskIndex.remove(task.id);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown() {
        running = false;
        dispatcher.interrupt();
        workerPool.shutdown();
    }
}

