package concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private final Semaphore semaphore = new Semaphore(2); // Allow up to 2 threads simultaneously

    public void accessResource() {
        try {
            semaphore.acquire(); // Request a permit
            System.out.println(Thread.currentThread().getName() + " acquired access");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " releases the resource");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Release the permit
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();
        Runnable task = example::accessResource;

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }
}
