package tesco;

public class CountPalindromicSubStrings {

    public static void main(String[] args) {
        System.out.println(palindromeSubStringCount("aaa"));
        System.out.println(palindromeSubStringCount("abc"));

    }

    public static int palindromeSubStringCount(String s) {
        int count = 0;
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int low = 0, high = 0;

        for (int i = 0; i < s.length(); i++) {

            low = i;
            high = i;
            //odd
            while ( (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high) )) {
                low--;
                high++;

                count++;

            }
            low=i;
            high=i+1;
            //even
            while ( (low >= 0 && high < s.length() && s.charAt(high) == s.charAt(low) )) {
                low--;
                high++;
                count++;
            }


        }


        return count;
    }
}
