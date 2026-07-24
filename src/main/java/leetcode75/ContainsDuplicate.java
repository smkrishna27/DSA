package leetcode75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {

        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;

            }
            set.add(num);

        }
        return false;


    }
}
