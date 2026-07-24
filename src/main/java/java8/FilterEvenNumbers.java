package java8;

import java.util.Arrays;
import java.util.List;

public class FilterEvenNumbers {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 3, 8, 1, 9);
        System.out.println(nums.stream().filter(num -> num % 2 == 0).toList());
        System.out.println(nums.stream().sorted().filter(num -> num % 2 != 0).toList());
    }
}
