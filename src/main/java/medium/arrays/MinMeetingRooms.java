package medium.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinMeetingRooms {


    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval  interval = new Interval(0,30);
        Interval  interval1 = new Interval(5,10);
        Interval  interval2= new Interval(15,20);

       //[[0,30],[5,10],[15,20]]
        List<Interval> list= new ArrayList<>();
        list.add(interval);
        list.add(interval1);
        list.add(interval2);
        System.out.println(minMeetingRooms(list));

    }

    public static int minMeetingRooms(List<Interval> intervals) {

        if (intervals.isEmpty()) return 0;
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start >= queue.peek()) {
                queue.poll();

            }
            queue.offer(intervals.get(i).end);
        }

        return queue.size();


    }
}
