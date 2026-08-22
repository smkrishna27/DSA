package medium.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[]{"bat","tab","cat","tac"} ));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];

        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;

            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);

            }

            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
