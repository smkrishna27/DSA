package Agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GetDistinctScore {
    public static void main(String[] args) {

        System.out.println(getDistinctScore(new int[]{4,3,2,4,6}));

        System.out.println(getDistinctScore(new int[]{5,3,5,5,5,1}));
        System.out.println(getDistinctScore(new int[]{6,5,4,6,1,1,5}));

    }

    public static  List<Integer> getDistinctScore(int[] arr) {

        TreeSet<Integer> result = new TreeSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int a : arr) {
            Set<Integer> current = new HashSet<>();
            current.add(a);
            for (int p : prev) {
                current.add(p | a);
            }
            result.addAll(current);
            prev = current;

        }
        List<Integer> ans = new ArrayList<>();
        int max = Arrays.stream(arr).max().getAsInt();
        ans.add(0);
        for (Integer a : result) {
            if(a<=max)
            ans.add(a);
        }

        return ans;

    }
}
