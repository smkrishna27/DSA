package medium.design.snakeandladder;

import javax.xml.crypto.Data;
import java.util.Random;

public class SingleDice implements Dice {
    @Override
    public int roll() {
        return new Random().nextInt(6) + 1;
    }
}
