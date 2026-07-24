package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaxSumOfDistinctSubarraysLengthk {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 4, 6, 7, 7, -1};
        int k = 4;
        //output 20

        System.out.println(maxSumSubarrays(nums, k));

    }

    public static int maxSumSubarrays(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap();

        int left = 0;
        int right = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (right - left + 1 == k) {
                if (map.size() == k) {
                    maxSum = Math.max(maxSum, sum);
                }
                sum -= nums[left];
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;

            }


        }

        return maxSum;


    }
}
