package medium.design.snakeandladder;

import lombok.Data;

@Data
public class Snake {

    private int tail;
    private int head;

    Snake(int tail, int head) {

        if (tail > head) {
            throw new UnsupportedOperationException("tail should not greater than head");
        }
        this.head = head;
        this.tail = tail;

    }
}
