package leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arr = new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}});
        for (int[] num : arr) {
            System.out.println(Arrays.toString(num));

        }


    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] cur = intervals[0];
        List<int[]> merge = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);

            } else {
                merge.add(cur);
                cur = intervals[i];
            }

        }
        merge.add(cur);

        return merge.toArray(new int[merge.size()][]);
    }
}
