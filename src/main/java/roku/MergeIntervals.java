package roku;


import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        for(int[] i :merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})) {
          //  System.out.print(Arrays.toString(i));
        }
        for(int[] i :mergeNew(new int[][]{{1,3},{3,6},{5,10},{15,18}})) {
            System.out.print(Arrays.toString(i));
        }

    }

    public static int[][] mergeNew(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0]; // setting first index
        res.add(newInterval);
        for(int[] interval : intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]=Math.max(interval[1],newInterval[1]);
                System.out.println((interval[0]));

            } else{
                System.out.println("notmatch"+Arrays.toString(interval));
                newInterval=interval;
              res.add(newInterval);

            }

        }

        return res.toArray(new int[res.size()][]);


    }


    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Traverse and merge
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlap → extend the end
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap → add current and move on
                merged.add(current);
                current = intervals[i];
            }
        }
        // Add the last interval
        merged.add(current);

        return merged.toArray(new int[merged.size()][]);



    }
}
