package roku;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcdabcbb"));
    }

    public static int longestSubstring(String s){

        Set<Character> set = new HashSet<>();
        if(s==null || s.isEmpty()) return 0;

        if(s.length()==1) return 1;

        int left = 0;
        int right ,max = Integer.MIN_VALUE;
        for(right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(right));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max,right-left+1);


        }
        return max;


    }
}
