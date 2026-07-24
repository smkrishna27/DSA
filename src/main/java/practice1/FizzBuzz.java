package practice1;

import java.util.stream.IntStream;

//7. FizzBuzz variant using Streams ( IntStream.rangeClosed ).
//Print numbers from 1 to N (commonly 100).
//
//For multiples of 3 → print "Fizz".
//
//For multiples of 5 → print "Buzz".
//
//For multiples of both 3 and 5 → print "FizzBuzz".
//
//Otherwise → print the number itself.
public class FizzBuzz {
    public static void main(String[] args) {
        IntStream.range(1, 100).forEach(i -> {
            if(i % 3 == 0) System.out.println("Fizz");
            if(i % 5 == 0) System.out.println("Buzz");
            if(i % 15 == 0) System.out.println("FizzBuzz");
        });

    }

}
