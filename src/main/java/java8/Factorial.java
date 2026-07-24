package java8;

import java.util.HashMap;

public class Factorial {
    final static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(factorial(5));

    }

    public static int factorial(int n) {
        if (n <= 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);

        }

        int result = n * factorial(n - 1);
        map.put(n, result);
        return result;
    }
}
