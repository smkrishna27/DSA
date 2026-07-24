package leetcode75;

import java.util.Arrays;

public class TwoPointerMaxNumberOfKSum {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1,2,3,4,5,6,7,8,9,10}, 3));

    }

    public static int maxOperations(int[] nums, int k) {

        int operations = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                operations++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }


        }
        return operations;
    }
}
