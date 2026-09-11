package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "BBABCCDD";
        int k = 2;
        //output=5

        System.out.println(longestRepeatingCharacter(s, k));

    }

    public static int longestRepeatingCharacter(String s, int k) {

        int maxfreq = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxlen = 0;
        for (int end = 0; end < chars.length; end++) {
            map.put(chars[end], map.getOrDefault(chars[end], 0) + 1);
            map.merge(chars[end],1, Integer::sum);
            maxfreq = Math.max(maxfreq, map.get(chars[end]));

            if ((end - start + 1) - maxfreq > k) {
                map.merge(chars[start],-1,Integer::sum);
                start++;
            }
            maxlen = Math.max(maxlen, end - start + 1);


        }

        return maxlen;

    }
}
