package tesco;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstingKdistinct {


    //s = "eceba", k = 2 answer =3
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringKDistinct("eceba",2));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring("ababc"));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int slow = 0;
        int fast = 0;
        for (fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            map.merge(c, 1, Integer::sum);
            while (map.size() > k) {
                char left = s.charAt(slow);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                    slow++;
                }
            }
            maxLen = Math.max(maxLen, fast - slow + 1);

        }

        return maxLen;


    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> map = new HashSet<>();
        int maxLen = 0;
        int slow = 0;
        int fast = 0;
        for (fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            while (map.contains(c)) {
                map.remove(s.charAt(slow));
                slow++;
            }
            map.add(c);
            maxLen = Math.max(maxLen, fast - slow + 1);
        }
        return maxLen;

    }

    public static String longestSubstring(String s) {

      /*  if (s == null || s.isEmpty()) return "";
        if (s.length() == 1) return s;
        int maxLen = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left=0;
        int right=0;

        for(right = 0; right < s.length(); right++){ //abcabcdefdef
            char curr=s.charAt(right); //a
            if(map.containsKey(curr) && map.get(curr)>=left){
                left =map.get(curr)+1; //left =0+1;
            }
            map.put(curr, right); // a ->0 b ->1, c ->1
            if(right - left + 1 > maxLen){
                maxLen = right - left + 1;
            }


        }
        return s.substring(left, left + maxLen);*/

        if(s==null || s.isEmpty())
            return "";
        if(s.length()==1)
            return s;

        Set<Character> map = new HashSet<>();
        int maxLen = 0;
        int slow = 0;
        int fast = 0;
        for (fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            while (map.contains(c)) {
                map.remove(s.charAt(slow));
                slow++;
            }
            map.add(c);
            maxLen = Math.max(maxLen, fast - slow + 1);
        }
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        return s.substring(slow,slow+maxLen);



    }


}
