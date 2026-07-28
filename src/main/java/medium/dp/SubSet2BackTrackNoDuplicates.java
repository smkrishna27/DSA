package medium.dp;

import com.amazonaws.services.dynamodbv2.xspec.L;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2BackTrackNoDuplicates {

    public static void main(String[] args) {

        System.out.println(subsetsWithOutDup(new int[]{1, 2, 1}));

    }

    public static List<List<Integer>> subsetsWithOutDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);

        return result;


    }

    private static void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.removeLast();
        }

    }
}
