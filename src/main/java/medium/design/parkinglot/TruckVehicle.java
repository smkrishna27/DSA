package medium.design.parkinglot;

import java.util.List;

public class TruckVehicle extends Vehicle {


    TruckVehicle(String plate) {
        super(plate);
    }

    @Override
    public List<SpotType> eligibleSpotTypes() {
        return List.of(SpotType.LARGE);
    }
}
