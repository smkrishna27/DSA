package Agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {

        System.out.println(findAnagrams("cbaebabacd","abc"));
        System.out.println(findAnagrams("abab", "ab"));

    }
    public static List<Integer> findAnagrams(String s, String p){

        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }
        int[] pMap = new int[26];
        int[] sMap = new int[26];

        for(int i=0;i<p.length();i++){
            pMap[p.charAt(i)-'a']++;
        }
        int window=p.length();
        for(int i=0;i<s.length();i++){
            sMap[s.charAt(i)-'a']++;
            if(i>=window){
                sMap[s.charAt(i-window)-'a']--;
            }
            if(Arrays.equals(pMap, sMap)){
                result.add(i-window+1);
            }

        }



        return result;
    }
}
