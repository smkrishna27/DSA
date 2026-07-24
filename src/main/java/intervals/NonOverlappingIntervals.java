package intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        //intervals = [[1,3],[5,8],[4,10],[11,13]]
        //op 1

        System.out.println(nonOverlappingIntervals(new int[][]{{1, 3}, {5, 8}, {4, 10},{11,13}}));

    }

    public static int nonOverlappingIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];

            } else {
                count++;
            }
        }
        return count;


    }
}
