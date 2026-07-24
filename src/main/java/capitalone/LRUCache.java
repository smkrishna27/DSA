package capitalone;

import java.util.*;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        // true = access-order (not insertion-order)
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // Evict when size exceeds capacity
    }

    public V getValue(K key) {
        return super.getOrDefault(key, null);
    }

    public void putValue(K key, V value) {
        super.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<String, Integer>  lruCache= new LRUCache<>(3);
        lruCache.put("key1", 1);
        lruCache.put("key2", 2);
        lruCache.put("key3", 3);
        System.out.println(lruCache);
        lruCache.put("key4", 4);
        System.out.println(lruCache);

    }
}

