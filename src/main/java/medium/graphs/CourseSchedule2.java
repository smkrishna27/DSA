package medium.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public static void main(String[] args) {

        //Input: numCourses = 3, prerequisites = [[0,1],[1,2],[2,0]]

        int[][] prerequisites = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        int courses = 3;
        System.out.println(Arrays.toString(findOrder(courses, prerequisites)));
        prerequisites = new int[][]{{1, 0}};
        courses = 3;

        System.out.println(Arrays.toString(findOrder(courses, prerequisites)));

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] visited = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            visited[index++] = course;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }


        }

        return index==numCourses?visited:new int[0];


    }
}
