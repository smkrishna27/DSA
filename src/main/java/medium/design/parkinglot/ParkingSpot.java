package medium.design.parkinglot;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ParkingSpot {
    private final String parkingId;
    @Getter
    private final int level;
    private final SpotType spotType;
    private Vehicle parkedVehicle;
    private final ReentrantLock lock = new ReentrantLock();

    public ParkingSpot(String parkingId, int level, SpotType spotType) {
        this.level = level;
        this.parkingId = parkingId;
        this.spotType = spotType;

    }


    public boolean tryPark(Vehicle vehicle) {
        lock.lock();
        try {
            if (parkedVehicle != null) return false;
            parkedVehicle = vehicle;
            return true;
        } finally {
            lock.unlock();
        }

    }

    public  Vehicle vacate() {
        lock.lock();
        try {
            Vehicle v = parkedVehicle;
            parkedVehicle = null;
            return v;
        } finally {
            lock.unlock();
        }
    }

    public boolean isFree() {
        return parkedVehicle == null;
    }

    public SpotType getType() {
        return spotType;
    }

    public String getId() {
        return parkingId;
    }

}
