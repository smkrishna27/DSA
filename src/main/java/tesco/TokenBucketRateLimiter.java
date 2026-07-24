package tesco;

public class TokenBucketRateLimiter {
    private final int capacity;   // max tokens
    private final int refillRate; // tokens per second
    private int tokens;
    private long lastRefill;

    public TokenBucketRateLimiter(int capacity, int refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefill = System.nanoTime();
    }

    public synchronized boolean allowRequest() {
        refill();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.nanoTime();
        long elapsed = now - lastRefill;
        int refillTokens = (int)((elapsed / 1_000_000_000L) * refillRate);
        if (refillTokens > 0) {
            tokens = Math.min(capacity, tokens + refillTokens);
            lastRefill = now;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Capacity = 3 tokens, refill rate = 2 tokens per second
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(3, 2);

        // First burst of requests
        System.out.println("Initial burst:");
        for (int i = 1; i <= 4; i++) {
            System.out.println("Request " + i + " allowed? " + limiter.allowRequest());
        }

        // Wait 1 second for refill
        Thread.sleep(1000);

        System.out.println("\nAfter 1 second:");
        for (int i = 5; i <= 7; i++) {
            System.out.println("Request " + i + " allowed? " + limiter.allowRequest());
        }

        // Wait 2 seconds for more refill
        Thread.sleep(2000);

        System.out.println("\nAfter 2 more seconds:");
        for (int i = 8; i <= 11; i++) {
            System.out.println("Request " + i + " allowed? " + limiter.allowRequest());
        }
    }
}

