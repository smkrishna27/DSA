package practice1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Find duplicates in an array in O(n) time/space using a HashSet
public class FindDuplicatesInArray {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findDuplicates(new int[]{1, 2, 3, 1})));

    }
    public  static int[] findDuplicates(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                duplicates.add(num);
            } else {
                seen.add(num);
            }
        }
        return duplicates.stream().mapToInt(Integer::intValue).toArray();

    }
}
