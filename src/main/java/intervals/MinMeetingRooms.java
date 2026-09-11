package intervals;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinMeetingRooms {


    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

    }

    public int minMeetingRooms(List<Interval> intervals) {

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
