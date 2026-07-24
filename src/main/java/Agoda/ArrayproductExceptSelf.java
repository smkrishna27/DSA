package Agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayproductExceptSelf {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 4, 6})));

    }

    public static int[] productExceptSelf(int[] nums) {


       int[] res = new int[nums.length];
        res[0]=1;

        for(int i=0;i<nums.length;i++){

            res[i]=res[i] * nums[i - 1];
            System.out.print(res[i]+" ");

        }
        int suffix=1;
        System.out.println();
        for(int i=nums.length-1;i>=0;i--){
            System.out.println(res[i]+" "+nums[i]+" ");
            res[i] *= suffix;
            suffix*=nums[i];


        }
        System.out.println();

        return res;

    }
}
