package leetcode75;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        SubSet subSet = new SubSet();
       // System.out.println(subSet.subsets(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(subSet.subsets(new int[]{1,2}));


    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result= new ArrayList<>();
        backtrack(nums,0,new ArrayList(),result);

        return result ;

    }
    public void backtrack(int[] nums,int start, List curr,List<List<Integer>> result){

        result.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            backtrack(nums,i+1,curr,result);
            curr.remove(curr.size()-1);
        }
    }
}
