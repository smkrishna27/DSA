package twopointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {

        sortColors(new int[]{2, 1, 2, 0, 1, 0, 1, 0, 1});


    }

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (mid <= right) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, left, mid);
                    left++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, right);

                    right--;
            }

        }

        System.out.println(Arrays.toString(nums));


    }

    private static void swap(int[] nums, int left, int mid) {
        int temp = nums[mid];
        nums[mid] = nums[left];
        nums[left] = temp;
    }
}
