package systemDesign.lowLevelDesign.problems.CarRentalSystem.paymentStrategy;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Payment;

public interface PaymentStrategy {
    Payment processPayment(Payment payment);
}
