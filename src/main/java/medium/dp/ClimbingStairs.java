package medium.dp;

/*
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(stairsDP(4));
        System.out.println(stairs(4));
    }

    public static int stairsDP(int stairs) {
        if (stairs < 2) return stairs;
        int[] dp = new int[stairs + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairs];
    }

    public static int stairs(int n) {
        if (n < 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;

        }
        return b;

    }
}
