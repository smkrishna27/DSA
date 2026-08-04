package medium.design.parkinglot;

import lombok.Getter;

import java.time.LocalDateTime;

public class Ticket {
    @Getter
    private final String ticketId;
    @Getter
    private final Vehicle vehicle;
    @Getter
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public void closeOut() {
        this.exitTime = LocalDateTime.now();
    }

    public long durationMinutes() {
        LocalDateTime end = exitTime != null ? exitTime : LocalDateTime.now();
        return java.time.Duration.between(entryTime, end).toMinutes();
    }

}