package leetcode75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {

        System.out.println(uniqueOccurrences(new int[]{1, 2, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));

    }
    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());

        return set.size() == map.size();

    }
}
