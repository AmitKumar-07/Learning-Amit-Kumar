package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.PaymentMode;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.PaymentStatus;

public class Payment {
    private String paymentId;
    private PaymentMode mode;
    private double amount;
    private PaymentStatus status;

    public Payment(String paymentId, PaymentMode mode, double amount) {
        this.paymentId = paymentId;
        this.mode = mode;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public void markSuccess() {
        this.status = PaymentStatus.SUCCESS;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public void setMode(PaymentMode mode) {
        this.mode = mode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
