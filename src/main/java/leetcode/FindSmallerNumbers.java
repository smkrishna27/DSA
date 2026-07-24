package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class FindSmallerNumbers {

    public static void main(String[] args) {
        FindSmallerNumbers findSmallerNumbers = new FindSmallerNumbers();
        System.out.println(Arrays.toString(findSmallerNumbers.smallerNumbersThanCurrentNew(new int[]{8,1,2,2,3})));
        System.out.println(Arrays.toString(findSmallerNumbers.smallerNumbersThanCurrent(new int[]{8,1,2,2,3})));
    }


    public int[] smallerNumbersThanCurrentNew(int[] nums) {
        int[] res = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {

            map.putIfAbsent(sorted[i],i);
        }
        for (int i = 0; i < nums.length; i++) {

               res[i] = map.get(nums[i]);

        }


        return res;

    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int max = Arrays.stream(nums)
                .max()
                .getAsInt()+1;

        int[] freq = new int[max];
        for (int num : nums) {

            freq[num]++;

        }

        for (int i = 1; i < max; i++) {
            freq[i] += freq[i - 1];
            System.out.println(freq[i]);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : freq[nums[i] - 1];
        }
        return result;
    }

}
