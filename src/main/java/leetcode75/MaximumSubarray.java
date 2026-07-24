package leetcode75;

public class MaximumSubarray {
    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
    public  static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum+num,num);
            max = Math.max(max, sum);

        }
        return max;
    }
}
