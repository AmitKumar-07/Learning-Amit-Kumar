package systemDesign.lowLevelDesign.problems.CarRentalSystem.pricingStrategy;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Car;

import java.time.Duration;
import java.time.LocalDateTime;

import static systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.CarType.SUV;

class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(Car car, LocalDateTime start, LocalDateTime end) {
        long hours = Duration.between(start, end).toHours();
        if (hours <= 0) hours = 1;

        switch (car.getCarType()) {
            case SUV: return hours * 300;
            case SEDAN: return hours * 200;
            default: return hours * 150;
        }
    }
}
