package medium.dp;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("ababd"));

    }

    public static int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (len == 2) ? 2 : dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }

        }

        return dp[0][n - 1];
    }
}
