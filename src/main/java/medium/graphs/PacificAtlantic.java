package medium.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {

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
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(heights, pacific, i, 0, heights[i][0]);//left column
            dfs(heights, atlantic, i, cols - 1, heights[i][cols - 1]);//right column
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacific, 0, j, heights[0][j]); // top row
            dfs(heights, atlantic, rows - 1, j, heights[rows - 1][j]); // bottom row
        }

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

    private static void dfs(int[][] heights, boolean[][] pacific, int i, int j, int previous) {
        int rows = heights.length;
        int cols = heights[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || heights[i][j] < previous) return;
        pacific[i][j] = true;

        dfs(heights, pacific, i - 1, j, heights[i][j]);
        dfs(heights, pacific, i+1, j , heights[i][j]);
        dfs(heights, pacific, i, j-1 , heights[i][j]);
        dfs(heights, pacific, i , j+1, heights[i][j]);

    }
}
