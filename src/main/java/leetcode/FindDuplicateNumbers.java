package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class FindDuplicateNumbers {

    public static void main(String[] args) {
        FindDuplicateNumbers findDuplicateNumbers = new FindDuplicateNumbers();
        System.out.println(Arrays.toString(findDuplicateNumbers.findDuplicate(new int[]{1, 1, 2, 3})));
        System.out.println(Arrays.toString(findDuplicateNumbers.findErrorNums(new int[]{1, 1, 2, 3})));

    }


    public int[] findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                duplicate = nums[i];
            } else {
                map.put(nums[i], i);
            }
        }
        int missing = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                missing = i;
            }
        }


        return new int[]{duplicate, missing};
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        int duplicate = -1;

        for (int num : nums) {
            if (seen[num]) {
                duplicate = num;
            }
            seen[num] = true;
        }

        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing = i;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }


}


