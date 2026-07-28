package medium.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EditDistance {
    public static void main(String[] args) {

        System.out.println(minDistance("Monkeys", "Money"));

    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] ;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    //dp[i-1][j] → delete
                    //
                    //dp[i][j-1] → insert
                    //
                    //dp[i-1][j-1] → replace

                }
            }

        }
        List<String> ops = new ArrayList<>();
        int i = word1.length(), j = word2.length();
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && word1.charAt(i-1) == word2.charAt(j-1)) {
                i--; j--; // no operation
            } else if (i > 0 && dp[i][j] == dp[i-1][j] + 1) {
                ops.add("Delete '" + word1.charAt(i-1) + "' at position " + (i-1));
                i--;
            } else if (j > 0 && dp[i][j] == dp[i][j-1] + 1) {
                ops.add("Insert '" + word2.charAt(j-1) + "' at position " + i);
                j--;
            } else if (i > 0 && j > 0 && dp[i][j] == dp[i-1][j-1] + 1) {
                ops.add("Replace '" + word1.charAt(i-1) + "' with '" + word2.charAt(j-1) + "' at position " + (i-1));
                i--; j--;
            }
        }

        Collections.reverse(ops);
        System.out.println(ops);


        return dp[word1.length()][word2.length()];


    }
}
