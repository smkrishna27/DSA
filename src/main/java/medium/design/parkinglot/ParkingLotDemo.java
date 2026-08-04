package medium.design.parkinglot;

import org.checkerframework.checker.units.qual.C;

import java.util.Map;
import java.util.Optional;

public class ParkingLotDemo {

    public static void main(String[] args) {

        ParkingLot lot = ParkingLot.getInstance();
        lot.setPricingStrategy(new FlatRatePricing());
        lot.addLevel(new Level(1, Map.of(
                SpotType.MOTOR_CYCLE, 5,
                SpotType.COMPACT, 10,
                SpotType.LARGE, 1)));

        Vehicle car = new TruckVehicle("KA-01-HH-1234");
        Optional<Ticket> ticket = lot.parkVehicle(car);
        ticket.ifPresent(t -> System.out.println("Parked at " + t.getSpot().getId() + ", ticket: " + t.getTicketId()));

        ticket.ifPresent(t -> {
            double fee = lot.unparkVehicle(t.getTicketId());
            System.out.println("Fee due: " + fee);
        });
    }
}
