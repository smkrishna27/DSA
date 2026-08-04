package medium.design.parkinglot;

import java.util.List;

public abstract class Vehicle {
    private final String licensePlate;

    protected Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public abstract List<SpotType> eligibleSpotTypes();
}