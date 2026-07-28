package medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        //Input: intervals = [[1,3],[1,5],[6,7]]
        //
        //Output: [[1,5],[6,7]]
        int[][] ans = merge(new int[][]{{1, 3}, {2, 3}, {1, 5}, {6, 7}});
        for (int[] i : ans) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merge = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);

            } else {
                merge.add(current);
                current = intervals[i];
            }

        }
        merge.add(current);

        return merge.toArray(new int[merge.size()][]);


    }
}
