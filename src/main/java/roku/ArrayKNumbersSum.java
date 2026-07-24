package roku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayKNumbersSum {
    public static void main(String[] args) {
        System.out.println(kSum(new int[]{1, 4, 45, 6, 10, 8}, 4,23));

    }
    public static List<List<Integer>> kSum(int[] nums, int k, int target) {
        Arrays.sort(nums);
        return kSumHelper(nums, k, target, 0);
    }
    public static List<List<Integer>> kSumHelper(int[] nums, int k, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if(k==2){
            if(nums==null||nums.length==0){
                result.add(new ArrayList<>());
                return result;

            }
            if(nums.length==1){
                result.add(new ArrayList<>(Arrays.asList(nums[0])));
                return result;
            }
            Arrays.sort(nums);
            int left=start;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum==target){
                    result.add(new ArrayList<>(Arrays.asList(nums[left],nums[right])));
                    return result;
                } else if(sum>target){
                    right--;
                } else if(sum<target){
                    left++;
                }

            }
            return result;

        }
        else if(k>2){
           for( int i=start; i<nums.length-k+1; i++){
               if(i>start && nums[i]==nums[i-1]) continue;
               List<List<Integer>> subResult = kSumHelper(nums, k-1, target-nums[i], i+1);
               for(List<Integer> sub : subResult ){
                   List<Integer> combo = new ArrayList<>();
                   combo.add(nums[i]);
                   combo.addAll(sub);
                   result.add(combo);

               }

           }

        }return  result;


    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0){
             result.add(new ArrayList<>());
             return result;

        }
        if(nums.length==1){
            result.add(new ArrayList<>(Arrays.asList(nums[0])));
            return result;
        }
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                result.add(new ArrayList<>(Arrays.asList(nums[left],nums[right])));
                return result;
            } else if(sum>target){
                right--;
            } else if(sum<target){
                left++;
            }

        }
        return result;


    }
}
