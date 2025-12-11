package systemDesign.lowLevelDesign.problems.CarRentalSystem.pricingStrategy;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Car;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculatePrice(Car car, LocalDateTime start, LocalDateTime end);
}
