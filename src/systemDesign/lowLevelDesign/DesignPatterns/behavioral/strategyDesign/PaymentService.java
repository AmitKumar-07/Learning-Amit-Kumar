package systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign.strategy.PaymentStrategy;

public class PaymentService {

    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void doPayment(int amount) {
        strategy.pay(amount);
    }
}
