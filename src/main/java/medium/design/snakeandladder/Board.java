package medium.design.snakeandladder;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    @Getter
    private int size;
    private Map<Integer, Integer> jumps = new HashMap<>();

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        for (Snake snake : snakes) {
            jumps.put(snake.getHead(), snake.getTail());
        }
        for (Ladder ladder : ladders) {
            jumps.put(ladder.getBottom(), ladder.getTop());
        }

    }

    public int getFinalPosition(int cell) {
        return jumps.get(cell) == null ? cell : jumps.get(cell);

    }


}
