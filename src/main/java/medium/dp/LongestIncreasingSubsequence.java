package medium.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        System.out.println(lengthOfLIS(new int[]{9,1,4,2,3,3,7}));

    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }

            max = Math.max(max, dp[i]);
            System.out.print(dp[i] +" ");
        }
        return max;
    }
}
