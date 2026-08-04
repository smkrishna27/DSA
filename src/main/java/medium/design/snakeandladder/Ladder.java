package medium.design.snakeandladder;

import lombok.Data;

@Data
public class Ladder {

    private int bottom;
    private int top;

    Ladder(int bottom, int top) {

        if (bottom > top) {
            throw new UnsupportedOperationException("bottom should not greater than top");
        }
        this.top = top;
        this.bottom = bottom;

    }
}
