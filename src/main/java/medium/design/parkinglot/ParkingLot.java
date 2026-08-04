package medium.design.parkinglot;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    private static final ParkingLot INSTANCE = new ParkingLot();
    private final List<Level> levels = new ArrayList<>();
    private final Map<String, Ticket> activeTickets = new java.util.concurrent.ConcurrentHashMap<>();
    private final AtomicInteger ticketCounter = new AtomicInteger(1);
    private PricingStrategy pricingStrategy = new HourlyPricing();

    private ParkingLot() {
    }

    public static ParkingLot getInstance() {
        return INSTANCE;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    /**
     * Facade method: find the best available spot across all levels and issue a ticket.
     */
    public Optional<Ticket> parkVehicle(Vehicle vehicle) {
        for (SpotType type : vehicle.eligibleSpotTypes()) {   // smallest-fit first
            for (Level level : levels) {
                Optional<ParkingSpot> spot = level.tryParkInType(vehicle, type);
                if (spot.isPresent()) {
                    String ticketId = "T" + ticketCounter.getAndIncrement();
                    Ticket ticket = new Ticket(ticketId, vehicle, spot.get());
                    activeTickets.put(ticketId, ticket);
                    return Optional.of(ticket);
                }
            }
        }
        return Optional.empty(); // lot full for this vehicle type
    }

    /**
     * Facade method: close out the ticket, free the spot, and return the fee owed.
     */
    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new IllegalArgumentException("Invalid ticket: " + ticketId);
        ticket.closeOut();
        ticket.getSpot().vacate();
        return pricingStrategy.calculateFee(ticket);
    }

    public int freeSpotCount(SpotType type) {
        return levels.stream().mapToInt(l -> l.freeCount(type)).sum();
    }
}