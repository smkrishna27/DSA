package tesco;

public class FindLongestSubstring {
    public static void main(String[] args) {

        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("cbbd"));
        System.out.println(longestSubstring("ac"));

    }

    public static String longestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }
        String lps = "";
        int low, high = 0;
        for (int i = 1; i < s.length(); i++) {
            low = i;
            high = i;

            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == s.length()) {
                    break;
                }

            }
            String palindrome = s.substring(low + 1, high);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }
            low = i - 1;
            high = i;
            while (s.charAt(high) == s.charAt(low)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) {
                    break;
                }
            }
            palindrome = s.substring(low + 1, high);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }


        }

        return lps;


    }
}
