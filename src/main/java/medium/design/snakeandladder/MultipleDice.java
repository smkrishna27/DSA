package medium.design.snakeandladder;

import java.util.Random;

public class MultipleDice implements Dice {

    private int count;

    MultipleDice(int count) {
        this.count = count;
    }


    @Override
    public int roll() {

        int total = 0;
        for (int i = 0; i < count; i++) {
            total += new Random().nextInt(6) + 1;
            ;
        }
        return total;
    }
}
