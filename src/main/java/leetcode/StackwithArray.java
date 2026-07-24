package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StackwithArray {
    public static void main(String[] args) {
        StackwithArray stackwithArray = new StackwithArray();
        System.out.println(stackwithArray.buildArray(new int[]{1,3},3));
    }

    private List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int j=0;
        for (int i = 1;  i<=n && j < target.length; i++) {
            res.add("push");
            if(i==target[j]){
                j++;
            }else{
                res.add("pop");
            }
        }

        return res;
    }
}
