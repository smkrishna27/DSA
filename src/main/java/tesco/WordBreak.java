package tesco;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    //Input: s = "leetcode", wordDict = ["leet","code"]
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet", "code")));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String word : wordSet) {
            maxLen = Math.max(maxLen, word.length());
        }

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[s.length()];
    }
}
