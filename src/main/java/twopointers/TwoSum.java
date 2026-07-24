package twopointers;

import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        //nums = [1,3,4,6,8,10,13]
        //target = 13
        //true
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(twoSum(new int[]{1, 3, 4, 6, 8, 10, 13}, 13));
        System.out.println(twoSum(new int[]{2, 4, 11, 15}, 9));

    }

    public static boolean twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }

        }
        return false;

    }


}
