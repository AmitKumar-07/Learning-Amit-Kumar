package systemDesign.lowLevelDesign.problems.DesignBookMyShow.service;

import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Booking;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.PaymentStatus;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Payment;

import java.util.UUID;

public class PaymentService {

    public Payment initiatePayment(Booking booking, String payMethod) {
        // mock payment gateway call
        System.out.println("Payment started for booking " + booking.getBookingId());
        Payment payment = new Payment();
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setPaymentMethod(payMethod);
        payment.setAmount(booking.getTotalAmount());
        payment.setBooking(booking);
        payment.setStatus(PaymentStatus.INITIATED);
        return payment; //payment initiated;
    }

    public void updatePaymentStatus(String paymentId, PaymentStatus status, Payment payment) {
        System.out.println("Payment " + paymentId + " status = " + status);
        payment.setStatus(status);
    }
}
