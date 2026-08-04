package medium.design.tictactoe;

public class Game {
    private final Board board;
    private final Player[] players;
    private int currentIndex;
    private GameState state = GameState.IN_PROGRESS;
    private final WinningStrategy winningStrategy;

    Game(int boardSize, String p1Name, String p2Name) {
        this.board = new Board(boardSize);
        players = new Player[]{new Player(p1Name, Symbol.X), new Player(p2Name, Symbol.O)};
        winningStrategy = new RowColDiagWinningStrategy();
    }

    public GameState play(int row, int col) {
        if (state != GameState.IN_PROGRESS) return state;
        Player current = players[currentIndex];
        if (!board.placeSymbol(row, col, current.getSymbol())) {
            System.out.println("Invalid move at (" + row + "," + col + "), try again.");
            return state;
        }

        if (winningStrategy.checkWinner(board, row, col, current.getSymbol())) {
            state = (current.getSymbol() == Symbol.X) ? GameState.X_WIN : GameState.O_WIN;
            return state;
        } else if (board.isFull()) {
            return GameState.DRAW;

        } else {
            currentIndex = 1 - currentIndex;
        }

        return state;


    }

    public GameState getState() {
        return state;
    }

    public Board getBoard() {
        return board;
    }

    public static void main(String[] args) {
        Game game = new Game(3, "Alice", "Bob");
        int[][] moves = {{0, 0}, {0, 2}, {0, 1}, {1, 1}, {1, 2},{2,0}}; // Alice wins top row
        for (int[] m : moves) {
            GameState s = game.play(m[0], m[1]);
            game.getBoard().print();
            System.out.println("State: " + s + "\n");
            if (s != GameState.IN_PROGRESS) break;
        }

    }
}
