package medium.design.parkinglot;

import java.util.List;

public class MotorVehicle extends Vehicle {


    MotorVehicle(String plate) {
        super(plate);
    }

    @Override
    public List<SpotType> eligibleSpotTypes() {
        return List.of(SpotType.MOTOR_CYCLE, SpotType.COMPACT, SpotType.LARGE);
    }
}
