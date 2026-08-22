package medium.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatingCharacter {


    public static void main(String[] args) {

        System.out.println(nonRepeatingCharacter("abcddea"));
        System.out.println(nonRepeatingCharacter("aabbcc"));
        System.out.println(nonRepeatingCharacter1("abcddea"));
        System.out.println(nonRepeatingCharacter1("aabbcc"));


    }

    public static char nonRepeatingCharacter(String s) {

        int[] freq = new int[26];
        for (char c = 0; c < s.length(); c++) {
            freq[s.charAt(c) - 'a']++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                return s.charAt(i);
            }
        }

        return '\0';

    }


    public static char nonRepeatingCharacter1(String s) {

        Map<Character,Integer> map= new LinkedHashMap<>();
        for (char c = 0; c < s.length(); c++) {
          map.merge(s.charAt(c),1,Integer::sum);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue() ==1){
                return entry.getKey();
            }


        }

        return '\0';

    }
}
