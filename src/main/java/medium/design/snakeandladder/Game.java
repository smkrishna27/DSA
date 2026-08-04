package medium.design.snakeandladder;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    private final Board board;
    private final Dice dice;
    private final Queue<Player> playerQueue;

    Game(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        playerQueue = new LinkedList<>(players);
    }

    public Player play() {
        while (true) {
            Player player = playerQueue.poll();
            Player winner = takeTurn(player);
            if (winner != null) return winner;
            playerQueue.offer(player);
        }
    }

    private Player takeTurn(Player player) {

        int roll = dice.roll();
        int tentative = player.getPosition() + roll;
        if (board.getFinalPosition(tentative) > board.getSize()) {

            return null;

        }
        int finalPos = board.getFinalPosition(tentative);
        String note = (finalPos != tentative)
                ? (finalPos > tentative ? " (climbed a ladder!)" : " (bitten by a snake!)")
                : "";
        System.out.println(player.getPlayerName() + " rolled " + roll + ": " + player.getPosition() +
                " -> " + tentative + note + " => " + finalPos);
        player.setPosition(finalPos);

        if (board.getSize() == board.getFinalPosition(tentative)) {
            System.out.println(player.getPlayerName() + " WINS!");
            return player;
        }

        return null;


    }

    public static void main(String[] args) {
        List<Snake> snakes = List.of(new Snake(54, 99), new Snake(55, 70), new Snake(42, 50), new Snake(2, 25));
        List<Ladder> ladders = List.of(new Ladder(6, 25), new Ladder(11, 40), new Ladder(60, 85), new Ladder(46, 90));

        Board board = new Board(100, snakes, ladders);
        Dice dice = new SingleDice();
        List<Player> players = List.of(new Player("Alice"), new Player("Bob"));

        Game game = new Game(board, dice, players);
        Player winner = game.play();
        System.out.println("\nWinner: " + winner.getPlayerName());
    }


}
