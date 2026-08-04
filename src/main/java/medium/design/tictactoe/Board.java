package medium.design.tictactoe;

import lombok.Getter;

import java.util.Arrays;

public class Board {
    private final Symbol[][] grid;
    @Getter
    private final int size;
    private int filledCells;


    Board(int size) {
        this.size = size;
        grid = new Symbol[size][size];
        for (Symbol[] row : grid) Arrays.fill(row, Symbol.EMPTY);
    }

    public boolean placeSymbol(int row, int col, Symbol symbol) {

        if (row < 0 || row >= size || col < 0 || col > size || !isCellEmpty(row, col)) {
            return false;

        }
        grid[row][col] = symbol;
        filledCells++;
        return true;

    }

    public boolean isFull() {
        return size * size == filledCells;
    }

    private boolean isCellEmpty(int row, int col) {

        return grid[row][col] == Symbol.EMPTY;

    }

    public Symbol get(int row, int col) {
        return grid[row][col];
    }

    public void print() {
        for (Symbol[] row : grid) {
            StringBuilder sb = new StringBuilder();
            for (Symbol s : row) sb.append(s == Symbol.EMPTY ? "." : s.name()).append(" ");
            System.out.println(sb);
        }

    }
}
