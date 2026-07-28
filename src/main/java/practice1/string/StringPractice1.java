package practice1.string;

import java.util.ArrayList;
import java.util.List;

public class StringPractice1 {

    public static void main(String[] args) {

        System.out.println(concatTypes("Hello", "world"));

    }

    public static List<String> concatTypes(String s1, String s2) {

        List<String> result = new ArrayList<>();
        result.add(s1 + s2);
        System.out.println(result);
        result.add(s1.concat(s2));
        result.add(s2.concat(s1));
        return result;


    }


}
