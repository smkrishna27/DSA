package java8;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcurrencyTest {
    public void fetch(String[] args) {
        CompletableFuture.supplyAsync(() -> Thread.currentThread().getName())
                .thenAccept(System.out::println); // e.g. ForkJoinPool.commonPool-worker-1

// Supplying a custom executor avoids sharing the common pool:
        ExecutorService pool = Executors.newFixedThreadPool(4);
        CompletableFuture.supplyAsync(this::longTask, pool);

    }

    public static void main(String[] args) {
       // new ConcurrencyTest().fetch(args);
        AtomicInteger counter = new AtomicInteger(0);

        Runnable increment = counter::incrementAndGet;
        int count=0;

        int k= IntStream.range(0, 1000).parallel().map(x -> counter.incrementAndGet()).reduce(0, Integer::sum);
        System.out.println(k);
        System.out.println(counter.get());
        System.out.println("multi");
        AtomicInteger sum = new AtomicInteger(0);

        List<CompletableFuture<Void>> tasks = IntStream.range(0, 5)
                .mapToObj(i -> CompletableFuture.runAsync(() -> process(i,sum)))
                .collect(Collectors.toList());

        CompletableFuture<Void> all = CompletableFuture.allOf(
                tasks.toArray(new CompletableFuture[0]));
        System.out.println("sum" +sum.get());

       // all.join();  // waits for all 5 tasks
        System.out.println("All tasks completed");

        List<Integer> squares = IntStream.rangeClosed(1, 10)
                .parallel()
                .boxed()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println("squares" +squares);





    }

    private static void process(int i, AtomicInteger sum) {
        sum.addAndGet(i);

    }

    private Object longTask() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {}
        return null;
    }
}
