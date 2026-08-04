package medium.design.parkinglot;

import java.util.List;
import java.util.*;

public class Level {
    private final int levelNumber;
    // group spots by type for fast lookup of the right kind of spot
    private final Map<SpotType, List<ParkingSpot>> spotsByType = new EnumMap<>(SpotType.class);

    public Level(int levelNumber, Map<SpotType, Integer> spotCounts) {
        this.levelNumber = levelNumber;
        for (var entry : spotCounts.entrySet()) {
            List<ParkingSpot> spots = new ArrayList<>();
            for (int i = 0; i < entry.getValue(); i++) {
                spots.add(new ParkingSpot(levelNumber + "-" + entry.getKey() + "-" + i, levelNumber, entry.getKey()));
            }
            spotsByType.put(entry.getKey(), spots);
        }
    }

    /**
     * Try to park in the first free spot of a given type on this level.
     */
    public Optional<ParkingSpot> tryParkInType(Vehicle vehicle, SpotType type) {
        for (ParkingSpot spot : spotsByType.getOrDefault(type, List.of())) {
            if (spot.isFree() && spot.tryPark(vehicle)) return Optional.of(spot);
        }
        return Optional.empty();
    }

    public int freeCount(SpotType type) {
        return (int) spotsByType.getOrDefault(type, List.of()).stream().filter(ParkingSpot::isFree).count();
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
