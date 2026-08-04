package medium.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        //Input: nums = [2,20,4,10,3,4,5]
        //
        //Output: 4

        System.out.println(longestConsecutive(new int[]{2, 20, 4, 10, 3, 4, 5}));

    }

    public static int longestConsecutive(int[] nums) {

        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                while (set.contains(current + 1)) {
                    current++;
                    longest++;

                }

            }


        }


        return longest;

    }
}
