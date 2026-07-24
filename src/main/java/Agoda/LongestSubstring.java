package Agoda;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {

        System.out.println(longestSubstring("abcabcbb"));
        System.out.println(longestSubstring("abcd"));

    }
    public static int  longestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int left=0;
        int right, maxlen=0;
        for(right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen,right-left+1);

        }
        return maxlen;
    }
}
