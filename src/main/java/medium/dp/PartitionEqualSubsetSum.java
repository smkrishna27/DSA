package medium.dp;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {

        System.out.println(canPartition(new int[]{1, 2, 3, 4}));

    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];

    }
}
