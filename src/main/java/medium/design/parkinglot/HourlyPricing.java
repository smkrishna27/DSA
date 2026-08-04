package medium.design.parkinglot;

public class HourlyPricing implements PricingStrategy {
    public double calculateFee(Ticket ticket) {
        long minutes = ticket.durationMinutes();
        double hours = Math.ceil(minutes / 60.0); // round up to next hour
        double ratePerHour = switch (ticket.getVehicle().eligibleSpotTypes().get(0)) {
            case MOTOR_CYCLE -> 10.0;
            case COMPACT -> 20.0;
            case LARGE -> 40.0;
        };
        return hours * ratePerHour;
    }
}
