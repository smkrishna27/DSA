package capitalone;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array arr[] of size n, the task is to find all the Leaders in the array. An element is a Leader if it is greater than or equal to all the elements to its right side.
 *
 * Note: The rightmost element is always a leader.
 *
 * Examples:
 *
 * Input: arr[] = [16, 17, 4, 3, 5, 2]
 * Output: [17 5 2]
 * Explanation: 17 is greater than all the elements to its right i.e., [4, 3, 5, 2], therefore 17 is a leader. 5 is greater than all the elements to its right i.e., [2], therefore 5 is a leader. 2 has no element to its right, therefore 2 is a leader.
 */

public class LeadersInArray {


    public static ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j;
            for (j = i+1 ; j < n; j++) {

                if (nums[i] <nums[j]) {
                    break;
                }

            }
            if(j == n)
                list.add(nums[i]);
        }
        return list;
    }

    public static ArrayList<Integer> leadersnew(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxRight = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= maxRight) {
                list.add(nums[i]);
                maxRight = nums[i];
            }
        }

        Collections.reverse(list);
        return list;
    }


    public static void main(String[] args) {

        int[] arr = { 16, 17, 4, 3, 5, 2 ,3};
        ArrayList<Integer> result = leaders(arr);

        for (int res : result) {
            System.out.print(res + " ");
        }
        System.out.println(leadersnew(arr));

    }

}
