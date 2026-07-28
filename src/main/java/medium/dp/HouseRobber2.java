package medium.dp;

public class HouseRobber2 {

    public static void main(String[] args) {
        //Input: nums = [3,4,3]
        //
        //Output: 4
        System.out.println(maxRob(new int[]{3,4,3,4}));

    }

    public static int maxRob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int case1 = robLiner(nums, 0, nums.length - 2);
        int case2 = robLiner(nums, 1, nums.length - 1);
        return Math.max(case1, case2);
    }

    private static int robLiner(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(prev1 , prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;

        }
        return prev1;

    }
}
