package roku;

import java.util.Arrays;

public class DPCoinChange {
    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange(new int[]{1,3,4,5},7));
        System.out.println(coinChange(new int[]{2},3));


    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
