package medium.dp;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(maxRob(new int[]{1, 3, 3,2 }));
        System.out.println(maxRob(new int[]{3}));

    }

    public static int maxRob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev2 = 0;
        int prev1 =0;
        for (int num : nums) {
            int cur = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
