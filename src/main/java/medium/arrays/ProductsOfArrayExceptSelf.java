package medium.arrays;

import java.util.Arrays;

public class ProductsOfArrayExceptSelf {

    public static void main(String[] args) {

        //Input: nums = [1,2,4,6]
        //
        //Output: [48,24,12,8]

        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 4, 6})));

    }


    public static int[] productExceptSelf(int[] nums) {


        int[] result = new int[nums.length];

        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
           // System.out.println(result[i]);
            //1,1,2,8
        }
        int suffix = 1;
        for (int i = nums.length-1 ; i >= 0; i--) {
            result[i] *= suffix;

            suffix *= nums[i];
            System.out.println( result[i] +" -> "+ suffix);
            //8,2,1,1
            //6,4,2,1
           //8,
            // 6,
        }

        return result;


    }
}
