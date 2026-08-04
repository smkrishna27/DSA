package medium.design.tictactoe;

public class RowColDiagWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, int lastRow, int lastCol, Symbol symbol) {

        int n = board.getSize();
        boolean rowWin = true, colWin = true;
        for (int i = 0; i < n; i++) {
            if (board.get(lastRow, i) != symbol) rowWin = false;
            if (board.get(i, lastCol) != symbol) colWin = false;

        }
        if (rowWin || colWin) {
            return true;
        }
        if (lastCol == lastRow) {
            boolean diag = true;

            for (int i = 0; i < n; i++) {
                if (board.get(i, i) != symbol) diag = false;

            }
            if (diag) return true;

        }
        if (lastCol + lastRow == n - 1) {

            boolean antidiag = true;

            for (int i = 0; i < n ; i++) {
                if (board.get(i, n - 1 - i) != symbol) {
                    antidiag = false;
                    break;
                }
            }
            if (antidiag) return true;

        }


        return false;
    }
}
