package tesco;

import java.util.Arrays;

public class MoveNonZeros {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{1, 2, 0, 4, 5, 6, 0, 8, 9})));

    }

    public static int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
        return nums;
    }
}
