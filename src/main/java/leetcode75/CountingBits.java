package leetcode75;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
       // System.out.println(Arrays.toString(countingBits(2)));
        System.out.println(Arrays.toString(countingBits(7)));

    }

    public static int[] countingBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i>>1] + (i&1);
            int k = i>>1;
            int j = i&1;
            //System.out.println(i+" "+res[i]+" " + k +" "+j);

        }

        int a = 5;  // 0101
        int b = 7;  // 0111

       /* System.out.println("a & b = " + (a & b));  // 5
        System.out.println("a | b = " + (a | b));  // 7
        System.out.println("a ^ b = " + (a ^ b));  // 2
        System.out.println("~a = " + ~a);          // -6
        System.out.println("a << 1 = " + (a << 1));// 10
        System.out.println("a >> 1 = " + (a >> 1));// 2*/



            int count = 0;
            while (n != 0) {
                System.out.print(n);
                n &= (n - 1);
                System.out.println(" "+ n+" "+count);
                count++;


        }

        return res;


    }
}
