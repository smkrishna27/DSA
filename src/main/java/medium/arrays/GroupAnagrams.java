package medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        //Input: strs = ["act","pots","tops","cat","stop","hat"]
        //
        //Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

        System.out.println(groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));
        System.out.println(groupAnagramUsingFrequency(new String[]{"act", "pots", "tops", "cat", "stop", "hat" ,"Aht"}));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {


        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);

        }


        return new ArrayList<>(map.values());


    }


    public static List<List<String>> groupAnagramUsingFrequency(String[] strs) {


        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];

            for (char c : str.toLowerCase().toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int num : count) {
                key.append('#').append(num);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);

        }


        return new ArrayList<>(map.values());


    }
}
