package medium.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //s = "eghghhgg"
        //output 3

      //  System.out.println(lengthOfLongestSubstring("zwxyzxyz"));
      //  System.out.println(lengthOfLongestSubstring("zxyyz"));
        System.out.println(lengthOfLongestSubstring("geeksforgeeks"));
        System.out.println(lengthOfLongestSubstringHashMap("geeksforgeeks"));

    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int start = 0;
        int maxlength = 0;
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
            //  System.out.println(s.charAt(left));
                left++;

            }
          //  System.out.println("out"+set);
            set.add(c);
            if (right - left + 1 >= maxlength) {
                maxlength = right - left + 1;
                start = left;
            }


        }
       // System.out.println(start);
        System.out.println(s.substring(start, start + maxlength));
        return maxlength;


    }

    public static int lengthOfLongestSubstringHashMap(String s) {

        Map<Character,Integer> map = new HashMap();
        int left = 0;
        int right = 0;
        int start = 0;
        int maxlength = 0;
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left=Math.max(left,map.get(c)+1);

            }
            //  System.out.println("out"+set);
            map.put(c,right);
            if (right - left + 1 >= maxlength) {
                maxlength = right - left + 1;
                start = left;
            }


        }
        // System.out.println(start);
        System.out.println(s.substring(start, start + maxlength));
        return maxlength;


    }
}
