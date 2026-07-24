package Agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abcdcbae", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("abab", "d"));


    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        int[] pmap = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pmap[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            window[s.charAt(right) - 'a']++;
            right++;
            //shink
            if (right - left > p.length()) {
                window[s.charAt(left) - 'a']--;
                left++;

            }

            if (Arrays.equals(pmap, window)) {
                ans.add(left);
            }


        }


        return ans;
    }
}
