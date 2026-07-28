package medium.dp;

import java.util.ArrayList;
import java.util.List;

public class PermutationsBackTrack {

    public static void main(String[] args) {

        System.out.println(permute(new int[]{1, 2, 3}));

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;


    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(result, temp, nums, used);
            temp.removeLast();
            used[i] = false;

        }


    }
}
