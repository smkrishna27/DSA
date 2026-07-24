package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        //intervals = [[1,3],[6,9]]
        //newInterval = [2,5]
        //op: [[1,5],[6,9]]

        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));

        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 3}, {6, 9}}, new int[]{3, 5})));

    }

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);


    }
}
