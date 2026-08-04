package medium.arrays;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {

       int res[][]=sum(new int[]{3, 4, 5, 2}, 7);
       for(int i[] :res)
        System.out.println(Arrays.toString(i));

    }

    public static int[][] sum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                list.add(new int[]{map.get(remain), i});

            }
            map.put(nums[i], i);

        }
       /* int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);

        }*/


        return list.toArray(new int[list.size()][2]);

    }
}
