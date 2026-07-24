package medium.graphs;

import com.amazonaws.services.dynamodbv2.xspec.L;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        //Input:
        //n = 5, edges = [[0,1],[1,2],[3,4]]
        //
        //Output: 2
        int[][] graph = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        int n = 5;
        System.out.println(countComponents(n, graph));

    }

    public static int countComponents(int n, int[][] edges) {

        int count = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());

        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                bfs(graph, i, visited);
                count++;
            }
        }


        return count;

    }

    private static void bfs(List<List<Integer>> graph, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;
                for (int next : graph.get(node)) {
                    queue.offer(next);
                }
            }

        }
    }


}
