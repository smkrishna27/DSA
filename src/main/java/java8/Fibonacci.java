package java8;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {


        System.out.println(fib(6));


    }

    static int fib(int n) {

        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Otherwise compute and store
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;

    }
}
