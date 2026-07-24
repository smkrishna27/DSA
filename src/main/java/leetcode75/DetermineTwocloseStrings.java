package leetcode75;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetermineTwocloseStrings {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc","acb"));
        System.out.println(closeStrings("abc","acd"));


    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (char c : word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }

        if (!freq1.keySet().equals(freq2.keySet())) return false;

        List<Integer> list1 = new ArrayList<>(freq1.values());
        List<Integer> list2 = new ArrayList<>(freq2.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);

    }
}
