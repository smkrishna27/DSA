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

        System.out.println(climbStairsDP(4));
        System.out.println(climbStairs(4));
        System.out.println(climbStairsRe(4));
        System.out.println(minCostClimbingStairs(new int[]{10,20,35,40}));
    }


    public static int climbStairsDP(int n) {


        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];


    }

    public static int climbStairsRe(int n) {


        if (n <= 2) return n;


        return climbStairsRe(n - 1) + climbStairsRe(n - 2);


    }


    public static int climbStairs(int n) {


        if (n < 2) return n;
        int a = 1;
        int b = 2;

        for (int i = 3; i <= n; i++) {
            int c = a + b; //3
            a = b; //
            b = c;

        }
        return b;


    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = 0, b = 0; // dp[0], dp[1]
        for (int i = 2; i <= n; i++) {
            int c = Math.min(a + cost[i-2], b + cost[i-1]);
            a = b;
            b = c;
        }
        return b;
    }


}
