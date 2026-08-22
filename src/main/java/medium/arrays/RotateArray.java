package medium.arrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        rotate(new int[]{3,4,5,6,7},6);


    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        System.out.println(Arrays.toString(nums));

    }

    static void reverse(int[] nums, int start, int end) {

        int i = start, j = end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }


}

