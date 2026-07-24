package intervals;

import java.util.Arrays;
import java.util.Comparator;

public class CanAttendMeetings {

    public static void main(String[] args) {
        //intervals = [(1,5),(3,9),(6,8)]
        //output false

        System.out.println(canAttendMeetings(new int[][]{{1, 5}, {3, 9}, {6, 8}}));
        System.out.println(canAttendMeetings(new int[][]{{10, 12}, {6, 9}, {13, 15}}));

    }

    public static boolean canAttendMeetings(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;


    }
}
