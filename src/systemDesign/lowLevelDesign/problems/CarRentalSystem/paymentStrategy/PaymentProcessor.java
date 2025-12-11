package systemDesign.lowLevelDesign.problems.CarRentalSystem.paymentStrategy;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Booking;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.PaymentStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Payment;

import java.util.UUID;

public class PaymentProcessor {

    public Payment processPayment(Booking booking, PaymentStrategy paymentStrategy) {
        Payment payment = new Payment(UUID.randomUUID().toString(), booking, booking.getAmount(), PaymentStatus.PENDING);
        return paymentStrategy.processPayment(payment);
    }
}
