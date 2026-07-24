package practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//5. Two Sum — given an array and target, return indices of the two numbers that add up to
//target ( HashMap for O(n)).
public class TwoSum {
    public static void main(String[] args) {
        for (int[] c : twoSum(new int[]{2, 7, 11, 15, 4, 5}, 9))
            System.out.println(Arrays.toString(c));


        System.out.println(twoSum2(new int[]{2, 7, 11, 15, 4, 5}, 9));

    }

    public static List<int[]> twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return Collections.singletonList(new int[]{nums[0]});
        }
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result.add(new int[]{map.get(target - nums[i]), i});
            }
            map.put(nums[i], i);
        }
        return result;

    }

    //use left and right approach
    public static List<List<Integer>> twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int left = 0;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(new ArrayList<>(Arrays.asList(left, right)));
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else  if (sum < target) {
                left++;
            }

        }
        return result;


    }

}
