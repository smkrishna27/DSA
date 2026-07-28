package medium.dp;

import java.util.List;

public class WordBreak {

    public static void main(String[] args) {

        System.out.println(wordBreak("badboy", List.of("bad", "boy")));
        System.out.println(wordBreak("badboy", List.of("bad", "boys")));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subString = s.substring(j, i);
                if (dp[j] && wordDict.contains(subString)) {
                    dp[i] = true;
                    break;
                }

            }

        }
        return dp[s.length()];
    }
}
