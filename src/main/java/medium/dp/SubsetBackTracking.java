package medium.dp;

import java.util.ArrayList;
import java.util.List;

public class SubsetBackTracking {

    public static void main(String[] args) {

        System.out.println(subsets(new int[]{1, 2, 3, 4}));

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(result, temp, nums, i + 1);
            temp.removeLast();
        }

    }
}
