package medium.graphs;

import java.util.LinkedList;
import java.util.Queue;

import static tech.tablesaw.aggregate.AggregateFunctions.max;

public class NumberOfMaxIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'0', '1', '1', '0', '1'},
                {'0', '1', '0', '0', '1'}
        };

        System.out.println(maxIsland(grid));
    }

    public static int maxIsland(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;
        int size = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // size = dfs(grid, i, j);
                    size = bfs(grid, i, j);
                    max = Math.max(max, size);

                }
            }
        }
        return max;
    }

    private static int bfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        int size = 1;
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0'; //visited
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : directions) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    size++;
                    queue.offer(new int[]{x, y});

                }

            }
        }

        return size;


    }

    private static int dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return 0;

        }
        grid[i][j] = '0';//visited
        int size = 1;// since it's have already one island
        size += dfs(grid, i + 1, j);
        size += dfs(grid, i - 1, j);
        size += dfs(grid, i, j + 1);
        size += dfs(grid, i, j - 1);
        return size;


    }
}
