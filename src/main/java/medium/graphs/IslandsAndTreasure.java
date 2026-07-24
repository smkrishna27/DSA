package medium.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasure {
    public static void main(String[] args) {
        //Input: [
        //  [2147483647,-1,0,2147483647],
        //  [2147483647,2147483647,2147483647,-1],
        //  [2147483647,-1,2147483647,-1],
        //  [0,-1,2147483647,2147483647]
        //]
        //
        //Output: [
        //  [3,-1,0,1],
        //  [2,2,1,-1],
        //  [1,-1,2,-1],
        //  [0,-1,3,4]
        //]


    }

    public static int[][] islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});

                }
            }
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {0, 0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < dirs.length; i++) {
                int x = curr[0] + dirs[i][0];
                int y = curr[1] + dirs[i][1];
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == Integer.MAX_VALUE) {
                    grid[x][y] = grid[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{x, y});
                }

            }


        }


        return grid;
    }
}
