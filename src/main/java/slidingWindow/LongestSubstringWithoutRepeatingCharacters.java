package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //s = "eghghhgg"
        //output 3

        System.out.println(lengthOfLongestSubstring("eghghhgg"));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // map.put(c, map.getOrDefault(c, 0) + 1);

           /* if(map.get(c)>1){
                map.put(c,map.get(c)-1);
                left++;
            }*/
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;


    }
}
