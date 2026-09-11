import java.util.concurrent.ThreadFactory;

public class VirtualThreadExample {
    // main function
    public static void main(String[] args) {
        try {

            Runnable printThread = () -> System.out.println(Thread.currentThread());

            ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
            ThreadFactory kernelThreadFactory = Thread.ofPlatform().factory();

            Thread virtualThread = virtualThreadFactory.newThread(printThread);
            Thread kernelThread = kernelThreadFactory.newThread(printThread);

            virtualThread.start();
            kernelThread.start();

            // Initialization of thread
            Thread.Builder builder = Thread.ofVirtual().name("GFG Thread");

            Runnable task = () -> {
                System.out.println("Running thread");
            };

            Thread t = builder.start(task);

            System.out.println("Thread t name: " + t.getName());

            // Add a delay to allow the virtual thread to run
            // Sleep for 1 second
            Thread.sleep(1000);

            // Wait for the thread to complete
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}