package twopointers;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {

       moveZeroes(new int[]{0,1,0,3,12});
       moveZeroes(new int[]{2,1,0,3,12});

    }

    public  static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;

       for (int right = 1; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }

        }
        System.out.println(Arrays.toString(nums));


    }
}
