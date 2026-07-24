package practice1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//9. Print all pairs in an array with a given sum, avoiding duplicate pairs.
public class AllPairsSum {
    public static void main(String[] args) {

        System.out.println(allPairsSum(new int[]{1, 2, 3, 2, 4, 5, 6, 3},7));

    }
    public  static Set<String> allPairsSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int num: nums) {
            int component =  target-num;
            if (seen.contains(component)) {
                int a=Math.min(component,num);
                int b=Math.max(component,num);
                output.add(a+" "+b);
            }
            seen.add(num);
        }

        return output;
    }
}
