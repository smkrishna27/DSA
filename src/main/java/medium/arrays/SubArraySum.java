package medium.arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubArraySum {

    public static void main(String[] args) {
        //Input: nums = [2,-1,1,2], k = 2
        //
        //Output: 4
        //Explanation: [2], [2,-1,1], [-1,1,2], [2] are the subarrays whose sum is equals to k.
        //
        //Example 2:
        //
        //Input: nums = [4,4,4,4,4,4], k = 4
        //
        //Output: 6

        System.out.println(subarraySum(new int[]{2, -1, 1, 2}, 2));
        System.out.println(subarraySum(new int[]{4, 4, 4, 4, 4, 4}, 4));

    }

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        }

        return count;


    }
}
