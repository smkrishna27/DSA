package tesco;

public class NumOfIslandsDFS {
    public static void main(String[] args) {

        char[][] grid2 = {
                {'1','1','1'},
                {'1','1','1'},
                {'1','1','1'}
        };

        System.out.println(numIslands(grid2));

    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //[
        //  ['1','1','0','0','0'],
        //  ['1','1','0','0','0'],
        //  ['0','0','1','0','0'],
        //  ['0','0','0','1','1']
        //]
        //if grid have value 1 increment
        //perform dfs for until grid 0
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;

    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j); //down
        dfs(grid, i + 1, j); //up
        dfs(grid, i, j + 1); //right
        dfs(grid, i, j - 1); //left
    }
}
