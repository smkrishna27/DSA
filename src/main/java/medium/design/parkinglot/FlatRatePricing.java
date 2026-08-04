package medium.design.parkinglot;

public class FlatRatePricing implements PricingStrategy {
    public double calculateFee(Ticket ticket) {
        return 50.0;
    }
}
