package medium.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {

        System.out.println(longestSubstringWihtOutRepeatingCharcter("ABCDAE"));

    }

    public static int longestSubstringWihtOutRepeatingCharcter(String s) {

        if (s == null) {
            return 0;
        }

        if (s.length() == 1)
            return 1;

        int left = 0, right = 0, max = 0;
        int start = 0;

        Set<Character> set = new HashSet<>();
        while (right < s.length()) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            if (right - left + 1 > max) {
                max = right - left + 1;
                start = left;
            }
            right++;


        }
        System.out.println(s.substring(start, start + max));

        return max;

    }
}
