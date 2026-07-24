package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class FindDuplicates {
    public static void main(String[] args) {
      int[]  arr = new int[]{1, 2, 3, 2, 4, 5, 1};
        duplicate(arr);


    }
    static void duplicate(int[] arr){

        Set<Integer> noDuplicate = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (!noDuplicate.add(j)) {
                list.add(j);
            }
        }

        System.out.println(list);
        System.out.println(noDuplicate);

        List<Integer> duplicates = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)       // keep only duplicates
                .map(Map.Entry::getKey)              // extract the duplicate element
                .collect(Collectors.toList());

        System.out.println(duplicates);




    }
}
