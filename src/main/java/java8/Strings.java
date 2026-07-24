package java8;

import java.util.HashMap;
import java.util.Map;

public class Strings {
    public static void main(String[] args) {
        System.out.println("a".equals(null));
        String a = null;
        //System.out.println(a.equals("a"));
        Map<String,String> map = new HashMap<>();
        map.put(a,"a");
        map.put(a,"b");
        String b = null;
        map.put(b,"c");
        System.out.println(map.get(a));
    }
}
