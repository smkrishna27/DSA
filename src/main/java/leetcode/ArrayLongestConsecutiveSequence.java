package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ArrayLongestConsecutiveSequence {

    public static void main(String[] args) {

        ArrayLongestConsecutiveSequence arrayLongestConsecutiveSequence = new ArrayLongestConsecutiveSequence();
        System.out.println(arrayLongestConsecutiveSequence.longestConsecutive(new int[]{1,2,1,4,5}));

    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            // only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }
        return longest;

    }
}
