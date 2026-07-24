package leetcode75;

public class SingleNumber {
    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{1,2,1,4,4}));
        int result=0;
        int [] nums={2,3,2};
        for(int num:nums) {
            result ^= num;
            //System.out.print( " "+ result +" ");
        }
        System.out.println(result);


    }

    public static int singleNumber(int[] nums) {
        int result=0;
        for(int num:nums)
            result^=num;

        return result;

    }
}
