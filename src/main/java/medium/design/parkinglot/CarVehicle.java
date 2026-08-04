package medium.design.parkinglot;

import java.util.List;

public class CarVehicle extends Vehicle {


    CarVehicle(String plate) {
        super(plate);
    }

    @Override
    public List<SpotType> eligibleSpotTypes() {
        return List.of(SpotType.COMPACT, SpotType.LARGE);
    }
}
