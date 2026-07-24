package medium.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingFruit {

    public static void main(String[] args) {
        //Input: grid = [[1,1,0],[0,1,1],[0,1,2]]
        //
        //Output: 4

        System.out.println(orangesRotting(new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 1, 2}}));


    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        System.out.println(rows + " " + cols);
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        int minutes = 0;

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] direction : directions) {
                    int x = cell[0] + direction[0];
                    int y = cell[1] + direction[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        fresh--;
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }


                }
            }
            minutes++;

        }
        return fresh == 0 ? minutes : -1;
    }
}
