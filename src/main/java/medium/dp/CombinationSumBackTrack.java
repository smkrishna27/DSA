package medium.dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumBackTrack {

    public static void main(String[] args) {

        System.out.println(combinationSum(new int[]{2, 5, 6, 9}, 9));

    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, target, 0);

        return result;

    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int target, int start) {

        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(result, temp, nums, target - nums[i], i);
                temp.removeLast();

            }

        }


    }

}
