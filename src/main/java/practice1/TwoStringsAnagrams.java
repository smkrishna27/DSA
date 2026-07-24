package practice1;

import java.util.Arrays;

//Check if two strings are anagrams (sort or frequency-count approach).
public class TwoStringsAnagrams {

    public static void main(String[] args) {

        System.out.println(twoStringsAnagrams("abcd", "bcda"));
        System.out.println(twoStringsAnagrams("abcd", "bcdae"));
        System.out.println(twoStringsAnagrams2("abcd", "cbak"));

    }

    public static boolean twoStringsAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1_arr = s1.toCharArray();
        char[] s2_arr = s2.toCharArray();
        Arrays.sort(s1_arr);
        Arrays.sort(s2_arr);
        return Arrays.equals(s1_arr, s2_arr);

    }

    public static boolean twoStringsAnagrams2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }

        }

        return true;


    }
}
