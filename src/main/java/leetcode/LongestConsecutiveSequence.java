package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }


        }
        return longest;


    }

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[]{2,20,4,10,3,4,5}));
    }
}
