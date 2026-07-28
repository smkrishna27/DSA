package medium.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sum(new int[]{3, 4, 5, 6}, 7)));

    }

    public static int[] sum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                return new int[]{map.get(remain), i};

            }
            map.put(nums[i], i);

        }

        return null;

    }
}
