package systemDesign.lowLevelDesign.problems.CarRentalSystem.pricingStrategy;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Car;

import java.time.Duration;
import java.time.LocalDateTime;

class DailyPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Car car, LocalDateTime start, LocalDateTime end) {
        long days = Duration.between(start, end).toDays();
        if (days <= 0) days = 1;

        switch (car.getCarType()) {
            case SUV: return days * 2000;
            case SEDAN: return days * 1500;
            default: return days * 1000;
        }
    }
}
