package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        //intervals = [[3,5],[1,4],[7,9],[6,8]]
        //op [[1,5],[6,9]]
        //after sort [1,4][3,5],[6,8][7,9]
        for (int[] s : mergeIntervals(new int[][]{{3, 5}, {1, 4}, {7, 9}, {6, 8}})) {
            System.out.println(Arrays.toString(s));
        }


    }

    public static int[][] mergeIntervals(int[][] intervals) {

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] previousEnd = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= previousEnd[1]) {
                previousEnd[1] = Math.max(intervals[i][1], previousEnd[1]);
            } else {
                result.add(previousEnd);
                previousEnd = intervals[i];
            }

        }
        result.add(previousEnd);


        return result.toArray(new int[result.size()][]);


    }


}
