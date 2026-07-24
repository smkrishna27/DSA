package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
 */
public class ArrayproductExceptSelf {
    public static void main(String[] args) {
        ArrayproductExceptSelf arrayproductExceptSelf = new ArrayproductExceptSelf();
      //  System.out.println(Arrays.toString(arrayproductExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(arrayproductExceptSelf.productExceptSelfNew(new int[]{1, 2, 4, 6})));

    }
    public int[] productExceptSelfNew(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
            System.out.print(result[i] + " ");

        }
        System.out.println(Arrays.toString(result));
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
            System.out.print(result[i] + " ");
        }
        System.out.println();

        return result;

    }

    public int[] productExceptSelf(int[] nums) {
       /* int[] res = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            int sum =1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    sum*=nums[j];
                }
            }
            res[i]=sum;
        }

        return res;*/

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];


        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
          //  System.out.println(result[i]);
            suffix *= nums[i];
            //System.out.println(nums[i]);

        }

        return result;

    }
}
