package systemDesign.lowLevelDesign.problems.CarRentalSystem;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.PaymentStatus;

public class Payment {
    String paymentId;
    Booking booking;
    double amount;
    PaymentStatus status;

    public Payment(String paymentId, Booking booking, double amount, PaymentStatus status) {
        this.paymentId = paymentId;
        this.booking = booking;
        this.amount = amount;
        this.status = status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }
}
