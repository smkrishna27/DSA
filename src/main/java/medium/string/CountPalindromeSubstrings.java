package medium.string;

public class CountPalindromeSubstrings {

    public static void main(String[] args) {

        System.out.println(countPalindromeSubstrings("daba"));


    }

    public static int countPalindromeSubstrings(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans += palindromeSubString(s, i, i);
            ans += palindromeSubString(s, i, i + 1);

        }

        return ans;

    }

    private static int palindromeSubString(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;


    }
}
