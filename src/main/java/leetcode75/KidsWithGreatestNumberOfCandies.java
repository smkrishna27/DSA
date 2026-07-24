package leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{1,2,3,1}, 1));

    }
    public static  List<Boolean> kidsWithCandies(int [] candies, int extraCandies){

        List<Boolean> res = new ArrayList<>(candies.length);
       int[] candidness = Arrays.copyOf(candies, candies.length);
       Arrays.sort(candidness);
       int maxCandie = candidness[candidness.length-1];
        for(int i = 0; i < candies.length; i++){
            if(candies[i]+extraCandies >= maxCandie){
               res.add(true);
            } else{
                res.add(false);
            }

        }

        return res;
    }
}
