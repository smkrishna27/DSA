package twopointers;

import java.util.Arrays;

public class TriangleNumbers {

    public static void main(String[] args) {
        //nums = [11,4,9,6,15,18]
        //output 10
        System.out.println(triangleNumber(new int[]{11, 4, 9, 6, 15, 18}));

    }


    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                System.out.print(nums[left] + " " + nums[right] + " " + nums[i]);
                if (sum > nums[i]) {
                    System.out.println();
                    count += right - left;
                    right--;

                } else {
                    left++;
                }
            }
            System.out.println();

        }
        return count;


    }
}
