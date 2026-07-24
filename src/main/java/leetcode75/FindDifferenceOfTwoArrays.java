package leetcode75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDifferenceOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(findDifferences(new int[]{1, 2, 4}, new int[]{1, 2, 3}));

    }
    public  static List<List<Integer>> findDifferences(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int j : nums1) {
            set1.add(j);
        }
        for (int j : nums2) {
            set2.add(j);
        }
       Set<Integer> result1=set1.stream().filter(x -> !set2.contains(x)).collect(Collectors.toSet());
        Set<Integer> result2=set2.stream().filter(x -> !set1.contains(x)).collect(Collectors.toSet());
        res.add(result1.stream().toList());
        res.add((result2.stream().toList()));
        return res;



    }
}
