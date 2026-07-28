package medium.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //s = "eghghhgg"
        //output 3

        System.out.println(lengthOfLongestSubstring("zxyzxyz"));

    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxlength = 0;
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            maxlength = Math.max(maxlength, right - left+1);
            set.add(c);


        }
        return maxlength;


    }
}
