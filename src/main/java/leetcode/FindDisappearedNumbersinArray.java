package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDisappearedNumbersinArray {

    //Input: nums = [4,3,2,7,8,2,3,1]
   // Output: [5,6]

    public static void main(String[] args) {
        FindDisappearedNumbersinArray findDisappearedNumbers = new FindDisappearedNumbersinArray();
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],nums[i]);
        }
        for (int i=1;i<=nums.length;i++){
            if (!map.containsKey(i)){
              res.add(i);
            }
        }

        return res;

    }
}
