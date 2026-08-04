package medium.design.tictactoe;

public interface WinningStrategy {

    boolean checkWinner(Board board, int lastRow, int lastCol, Symbol symbol);
}
