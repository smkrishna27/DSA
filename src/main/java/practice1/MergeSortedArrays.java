package practice1;

import java.util.Arrays;

//8. Merge two sorted arrays in place.
public class MergeSortedArrays {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(mergeSortedArrays(new int[]{3,4,5}, new int[]{2,5,6})));

    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int i = m - 1, j = n - 1, k = m + n-1;
        int[] res = new int[m+n];

        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                res[k--] = arr1[i--];
            } else {
                res[k--] = arr2[j--];
            }
        }

        while (j >= 0) {
            res[k--] = arr2[j--];
        }
        while (i >= 0) {
            res[k--] = arr1[j--];
        }

        return res;
    }
}
