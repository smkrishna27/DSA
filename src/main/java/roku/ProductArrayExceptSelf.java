package roku;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{3,2,3,1})));

    }
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int suffix=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i] *=suffix;
            suffix*=nums[i];

        }


        return res;
    }

}
