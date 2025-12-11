package systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign.strategy.CreditCardPayment;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign.strategy.UPIPayment;

public class Main {
    public static void main(String[] args) {

        PaymentService paymentService = new PaymentService();

        paymentService.setStrategy(new CreditCardPayment());
        paymentService.doPayment(500);   // Card

        paymentService.setStrategy(new UPIPayment());
        paymentService.doPayment(300);   // UPI
    }
}
