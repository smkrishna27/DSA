package tesco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        //schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
        List<List<Interval>> intervals = new ArrayList<>();
        List<Interval> interval1 = new ArrayList<>();
        interval1.add(new Interval(1, 2));
        interval1.add(new Interval(5, 6));
        List<Interval> interval2 = new ArrayList<>();
        interval2.add(new Interval(1, 3));
        List<Interval> interval3 = new ArrayList<>();
        interval3.add(new Interval(4, 10));
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);

        List<Interval> interval4 = employeeFreeTime(intervals);
        for (Interval i : interval4) {
            System.out.println(i.start + " " + i.end);
        }


    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> intervals) {
        List<Interval> all = new ArrayList<>();
        intervals.forEach(all::addAll);
        all.sort(Comparator.comparingInt(a -> a.start));
        List<Interval> merged = new ArrayList<>();
        Interval curr = all.get(0);
        for (int i = 1; i < all.size(); i++) {
            if (all.get(i).start <= curr.end) {
                curr.end = Math.max(curr.end, all.get(i).end);
            } else {
                merged.add(curr);
                curr = all.get(i);
            }

        }
        merged.add(curr);
        //now find free time gaps
        List<Interval> free = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            free.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        }


        return free;


    }


    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}
