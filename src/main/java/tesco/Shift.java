package tesco;

import com.tesco.Skill;
import lombok.Data;

@Data
public class Shift {
    private int shiftId;
    private Skill skill;
    private int totalDuration;

}
