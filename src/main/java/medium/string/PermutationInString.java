package medium.string;

import java.util.Arrays;

public class PermutationInString {

    //Input: s1 = "abc", s2 = "lecabee"
    //
    //Output: true
    //Input: s1 = "abc", s2 = "lecaabee"
    //
    //Output: false

    public static void main(String[] args) {

        System.out.println(checkInclusion("abc","lecabee"));

        System.out.println(checkInclusion("abc","lecaabee"));

    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        int window = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
            if (i >= window) {
                s2Count[s2.charAt(i - window) - 'a']--;
            }

            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }


        }


        return false;

    }
}
