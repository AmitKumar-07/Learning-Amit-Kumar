package systemDesign.lowLevelDesign.problems.CarRentalSystem.paymentStrategy;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.PaymentStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Payment;

public class UPIPayment implements PaymentStrategy{

    @Override
    public Payment processPayment(Payment payment) {
        System.out.println("Processing upi payment of $" + payment.getAmount());
        // Logic for credit card payment processing would go here
        payment.setStatus(PaymentStatus.SUCCESS);
        return payment;
    }
}
