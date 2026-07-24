package leetcode75;

public class IncreasingTriplet {

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(increasingTriplet(new int[]{3,1,5,4}));

    }
    public static boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length==0) return false;
        if(nums.length<2) return false;
        int lef=Integer.MAX_VALUE;
        int righ=Integer.MAX_VALUE;
        for(int num:nums){
          if(num<lef) lef=num;
          else if(num<righ) righ=num;
          else
              return true;

        }
        return false;

    }
}
