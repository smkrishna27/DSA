package Agoda;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingJAVAClass<k,v>  extends LinkedHashMap<k,v> {

    int capacity;

    LRUCacheUsingJAVAClass(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size() > capacity;
    }


    public v put(k key, v value){
        super.put(key,value);

        return value;
    }
    public v get(Object key){
        return super.get(key);
    }



    public static void main(String[] args) {
        LRUCacheUsingJAVAClass<String,Integer> stringIntegerLRUCacheUsingJAVAClass= new LRUCacheUsingJAVAClass<>(4);
        stringIntegerLRUCacheUsingJAVAClass.put("key1",3);
        stringIntegerLRUCacheUsingJAVAClass.put("key2",2);
        stringIntegerLRUCacheUsingJAVAClass.put("key3",1);

        stringIntegerLRUCacheUsingJAVAClass.put("key4",3);
        stringIntegerLRUCacheUsingJAVAClass.put("key5",1);
        System.out.println( stringIntegerLRUCacheUsingJAVAClass.keySet());
        stringIntegerLRUCacheUsingJAVAClass.get("key1");
        System.out.println( stringIntegerLRUCacheUsingJAVAClass.keySet());

    }



}
