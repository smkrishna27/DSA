import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Represents an Order in the Landmark E-commerce system.
 */
class Order implements Comparable<Order> {
    private final String orderId;
    private final int priority; // Higher value means higher priority
    private final long sequenceNumber; // To enforce FIFO when priorities are equal

    public Order(String orderId, int priority, long sequenceNumber) {
        this.orderId = orderId;
        this.priority = priority;
        this.sequenceNumber = sequenceNumber;
    }

    public String getOrderId() { return orderId; }
    public int getPriority() { return priority; }

    @Override
    public int compareTo(Order other) {
        // Sort by priority descending
        int res = Integer.compare(other.priority, this.priority);
        if (res == 0) {
            // FIFO fallback using the atomic sequence number
            return Long.compare(this.sequenceNumber, other.sequenceNumber);
        }
        return res;
    }
}

/**
 * Thread-safe Order Processing Engine optimized for high throughput.
 */
public class OrderProcessingEngine {

    public static void main(String[] args) {
        // Single worker thread helps track deterministic execution order
        OrderProcessingEngine engine = new OrderProcessingEngine(1);

        // Ingest mixed priority items rapidly
        engine.ingestOrder("REGULAR_CUSTOMER_1", 1);
        engine.ingestOrder("GOLD_CUSTOMER_1", 5);
        engine.ingestOrder("VIP_CUSTOMER_1", 10);
        engine.ingestOrder("GOLD_CUSTOMER_2", 5); // Same priority as GOLD_1, must execute AFTER

        // Gracefully drain and block until all 4 orders print to the console
        engine.shutdown();
    }

    // Thread-safe monotonic counter to preserve arrival order (FIFO fallback)
    private final AtomicLong sequencer = new AtomicLong(0);

    // Unbounded thread-safe priority queue
    private final PriorityBlockingQueue<Order> orderQueue = new PriorityBlockingQueue<>();

    // Dedicated executor pool for worker threads
    private final ExecutorService workerExecutor;

    // State flag protected by a lock to ensure thread-safe shutdown sequencing
    private final ReentrantLock stateLock = new ReentrantLock();
    private volatile boolean isShutdownInitiated = false;

    public OrderProcessingEngine(int coreWorkerCount) {
        // Initialize an explicit thread pool with named daemon threads for safety
        this.workerExecutor = Executors.newFixedThreadPool(coreWorkerCount, r -> {
            Thread t = new Thread(r);
            t.setName("Order-Processor-Worker");
            return t;
        });

        // Start worker threads to consume queued orders
        for (int i = 0; i < coreWorkerCount; i++) {
            workerExecutor.submit(this::processQueueLoop);
        }
    }

    /**
     * Ingests a new order into the processing pipeline.
     * @return true if successfully ingested, false if engine is shutting down.
     */
    public boolean ingestOrder(String orderId, int priority) {
        stateLock.lock();
        try {
            if (isShutdownInitiated) {
                return false; // Reject new orders during shutdown
            }

            // Assign a sequence number and offer to the priority queue
            long seq = sequencer.getAndIncrement();
            orderQueue.offer(new Order(orderId, priority, seq));
            return true;
        } finally {
            stateLock.unlock();
        }
    }

    /**
     * Continuous loop executed by worker threads to consume orders.
     */
    private void processQueueLoop() {
        try {
            // Keep pulling while the queue has items, or if the system isn't fully shut down
            while (!isShutdownInitiated || !orderQueue.isEmpty()) {
                // Poll with a small timeout to prevent threads from hanging indefinitely during shutdown
                Order order = orderQueue.poll(500, TimeUnit.MILLISECONDS);

                if (order != null) {
                    executeOrderFulfillment(order);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }

    /**
     * Simulates the actual backend order processing logic.
     */
    private void executeOrderFulfillment(Order order) {
        // Business logic execution (e.g., Inventory allocation, payment capture)
        System.out.println(Thread.currentThread().getName() + " executed Order: "
                + order.getOrderId() + " [Priority: " + order.getPriority() + "]");
    }

    /**
     * Initiates a graceful shutdown of the engine.
     * Rejects new inputs, clears outstanding tasks, and shuts down the executor pool.
     */
    public void shutdown() {
        stateLock.lock();
        try {
            if (isShutdownInitiated) return;
            isShutdownInitiated = true;
        } finally {
            stateLock.unlock();
        }

        // Shutdown the worker threads gracefully
        workerExecutor.shutdown();
        try {
            // Await execution of remaining orders in the priority queue
            if (!workerExecutor.awaitTermination(30, TimeUnit.SECONDS)) {
                workerExecutor.shutdownNow(); // Force kill if it takes too long
            }
        } catch (InterruptedException e) {
            workerExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
