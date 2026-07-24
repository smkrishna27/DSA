package leetcode;

import algorithms.sorts.bubblesort.BubbleSort;

import java.util.Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {

        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentMax++;
                if (currentMax > max) {
                    max = currentMax;
                }
            } else {
                if (currentMax > max) {
                    max = currentMax;
                }
                currentMax = 0;

            }
        }
        return max;
    }
}
