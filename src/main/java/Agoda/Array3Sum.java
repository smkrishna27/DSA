package Agoda;

import java.util.Arrays;

public class Array3Sum {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(threeSumClosest(new int[]{1, 4, 45, 6, 10, 8},22)));
        System.out.println(Arrays.toString(threeSumClosest(new int[]{1, 4, 45, 6, 10, 8},20)));
        System.out.println(Arrays.toString(fourSumClosest(new int[]{1, 4, 45, 6, 10, 8},21)));

    }


    public static int[] threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            int sum=0;
            while (left < right) {
              sum = nums[i] + nums[left] + nums[right];
                if(sum ==  target){
                    return new int[]{nums[i], nums[left], nums[right]};
                }else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }


        }
        return null;

    }
    public static int[] fourSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = i + 1, right = nums.length - 1;
                int sum = 0;
                while (left < right) {
                    sum = nums[i] +nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        return new int[]{nums[i],nums[j], nums[left], nums[right]};

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }


        }
        return null;
    }
}
