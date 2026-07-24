package roku;

import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<k,v> extends LinkedHashMap<k,v> {

    int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer,Integer> cache = new LRUCache<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.entrySet());
    }


}
