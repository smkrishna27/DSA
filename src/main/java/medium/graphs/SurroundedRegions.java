package medium.graphs;

public class SurroundedRegions {

    public static void main(String[] args) {
        //Input: board = [
        //  ["X","X","X","X"],
        //  ["X","O","O","X"],
        //  ["X","X","O","X"],
        //  ["X","O","X","X"]
        //]
        //
        //Output: [
        //  ["X","X","X","X"],
        //  ["X","X","X","X"],
        //  ["X","X","X","X"],
        //  ["X","O","X","X"]
        //]

        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);

    }

    public static void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0); //firstrow
            dfs(board, i, cols - 1); //firstrow last  column
        }
        for (int i = 0; i < cols; i++) {
            dfs(board, 0, i); //fist column
            dfs(board, rows - 1, i);//lastrow first column
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }


    }

    private static void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);

    }
}
