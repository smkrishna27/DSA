package medium.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        //1234 false
        //1233 true

        System.out.println(hasDuplicate(new int[]{1, 2, 3, 3}));

        System.out.println(hasDuplicate(new int[]{1, 2, 3, 4}));

    }

    public static boolean hasDuplicate(int[] nums) {

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
