package medium.graphs;

import java.util.*;

public class PacificAtlanticBFS {

    public static void main(String[] args) {
        //Input: heights = [
        //  [4,2,7,3,4],
        //  [7,4,6,4,7],
        //  [6,3,5,3,6]
        //]
        //
        //Output: [[0,2],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0]]




    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        // Pacific borders
        for (int i = 0; i < rows; i++) {
            pacQueue.offer(new int[]{i, 0}); //left column
            atlQueue.offer(new int[]{i, cols - 1}); //right column
            pacific[i][0] = true;
            atlantic[i][cols - 1] = true;
        }
        for (int j = 0; j < cols; j++) {
            pacQueue.offer(new int[]{0, j}); // top row
            atlQueue.offer(new int[]{rows - 1, j}); //bottom row
            pacific[0][j] = true;
            atlantic[rows - 1][j] = true;
        }

        bfs(heights, pacQueue, pacific);
        bfs(heights, atlQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private static void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int nr = cell[0] + d[0],
                        nc = cell[1] + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                        !visited[nr][nc] && heights[nr][nc] >= heights[cell[0]][cell[1]]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
