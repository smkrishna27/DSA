package medium.arrays;

import leetcode.Array3Sum;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String[] args) {


        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));


    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (left < right && sum == target) {
                    int[] result = new int[]{nums[i], nums[left], nums[right]};
                    res.add(Arrays.stream(result)
                            .boxed()
                            .collect(Collectors.toList()));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }


            }


        }

        return res;


    }
}
