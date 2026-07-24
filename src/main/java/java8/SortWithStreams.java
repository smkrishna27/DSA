package java8;

import java.util.Arrays;
import java.util.List;

public class SortWithStreams {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 3, 8, 1, 9);
        System.out.println(nums.stream().sorted().toList());
    }
}
