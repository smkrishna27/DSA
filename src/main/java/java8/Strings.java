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

        String s="Hello";
        String s1="Hello";
        String s2=new String("Hello");
        System.out.println(s==s1);
        System.out.println(s==s2);
        System.out.println(s.equals(s2));
        s.concat(" world");
        System.out.println(s);
    }
}
