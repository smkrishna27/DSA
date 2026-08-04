package medium.design.parkinglot;

public interface PricingStrategy {
    double calculateFee(Ticket ticket);
}

