package leetcode;

import java.util.Arrays;

public class ConcactArrays {

    public  static int[] getConcatenation(int[] nums) {

        int[] concat= new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            concat[i]=nums[i];
        }


        for(int i = 0, j = nums.length;i<nums.length && j< nums.length*2 ;i++,j++){

                concat[j] = nums[i];


        }
        return concat;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1,2,3,4})));

    }
}
