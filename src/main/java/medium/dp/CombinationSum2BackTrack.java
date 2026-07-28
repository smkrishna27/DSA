package medium.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2BackTrack {

    public static void main(String[] args) {

        System.out.println(combinationSum(new int[]{9,2,2,4,6,1,5}, 8));

    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
       //  Arrays.sort(nums);

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
              if(i>start && nums[i] ==nums[i-1])
                  continue;
                temp.add(nums[i]);
                backtrack(result, temp, nums, target - nums[i], i+1);
                temp.removeLast();

            }

        }


    }

}
