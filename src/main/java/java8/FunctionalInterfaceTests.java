package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTests {
    public static void main(String[] args) {

        Function<Integer,Integer> multiply = i->i*i;
        System.out.println(multiply.apply(5));
        int factorial = 50;
        Function<Integer,Integer> mul = i->i*factorial;
        System.out.println(mul.apply(5));
        Function<Integer, Integer> square = x -> x * x;
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Consumer<String> print = System.out::println;
        Supplier<Double> random = Math::random;
        System.out.println(random.get());
        System.out.println(square.apply(5));
        System.out.println(isEven.test(5));
        print.accept("Hello");




    }


}
