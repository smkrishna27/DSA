package medium.design.snakeandladder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Player {

    private String playerName;
    private int position;

    Player(String playerName) {
        this.playerName = playerName;
    }
}
