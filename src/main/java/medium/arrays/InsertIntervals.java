package medium.arrays;

import com.amazonaws.services.dynamodbv2.xspec.M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertIntervals {

    public static void main(String[] args) {
        //Input: intervals = [[1,3],[1,5],[6,7]]
        //
        //Output: [[1,5],[6,7]]
        int[][] ans = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> insert = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            insert.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        insert.add(newInterval);


        while (i < intervals.length) {
            insert.add(intervals[i]);
            i++;
        }


        return insert.toArray(new int[insert.size()][]);


    }
}
