package leetcode75;
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

        System.out.println(climbStairs(4));

    }
    public static int climbStairs(int n) {
        if(n<2) return n;
        int a=1,b=2;
        for(int i=3;i<=n;i++){
            int c=a+b;
            a=b;
            b=c;
        }

        return b;

    }
}
