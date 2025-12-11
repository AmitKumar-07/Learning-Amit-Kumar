package systemDesign.lowLevelDesign.problems.CarRentalSystem.paymentStrategy;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.PaymentStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Payment;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public Payment processPayment(Payment payment) {
        System.out.println("Processing credit card payment of $" + payment.getAmount());
        // Logic for credit card payment processing would go here
        payment.setStatus(PaymentStatus.FAILED); // Let say payment got failed for any reason
        return payment;
    }
}
