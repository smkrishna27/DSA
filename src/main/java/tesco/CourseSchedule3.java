package tesco;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseSchedule3 {
    public static void main(String[] args) {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(scheduleCourse(courses));

    }

    // [[100,200],[200,1300],[1000,1250],[2000,3200]]
    //duration and lastDay
    //ourout -> 3
    public static int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            pq.add(duration);
            time += duration;
            System.out.println("time " + time + " lastDay "+ lastDay + " added " +pq);
            if (time > lastDay) {
                time-=pq.poll();
            }

        }
        return pq.size();


    }
}
