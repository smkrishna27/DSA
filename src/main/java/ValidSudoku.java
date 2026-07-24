import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {


    public boolean validSudoku(char[][] board) {

            boolean[][] rows = new boolean[9][9];
            boolean[][] cols = new boolean[9][9];
            boolean[][] boxes = new boolean[9][9];

            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if (board[r][c] == '.') continue;
                    int num = board[r][c] - '1';
                    int boxIndex = (r / 3) * 3 + (c / 3);

                    if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                        return false;
                    }
                    rows[r][num] = cols[c][num] = boxes[boxIndex][num] = true;
                }
            }
            return true;

        }


    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] gridSet = new HashSet[9];
        for (int i = 0; i < 9; i++){
            rowSet[i]= new HashSet();
            colSet[i]= new HashSet();
            gridSet[i]= new HashSet();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int gridNo= (i/3) * 3 + j/3;
                if (board[i][j] != '.') {
                    boolean isPresentInRow = rowSet[i].contains(board[i][j]);
                    boolean isPresentInCol= colSet[j].contains(board[i][j]);
                    boolean isPresentInGrid= gridSet[gridNo].contains(board[i][j]);
                    if (isPresentInRow || isPresentInCol || isPresentInGrid) {
                        return false;

                    }
                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                    gridSet[gridNo].add(board[i][j]);
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku mc = new ValidSudoku();
        char[][] board = new char[9][9];
        System.out.println(mc.isValidSudoku(new char[][]{}));


    }

}
