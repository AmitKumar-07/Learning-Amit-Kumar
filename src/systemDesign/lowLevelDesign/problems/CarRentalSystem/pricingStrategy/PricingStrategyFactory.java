package systemDesign.lowLevelDesign.problems.CarRentalSystem.pricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class PricingStrategyFactory {

    public static PricingStrategy chooseStrategy(LocalDateTime start, LocalDateTime end) {

        long hours = Duration.between(start, end).toHours();

        if (hours < 24) {
            return new HourlyPricingStrategy();
        } else {
            return new DailyPricingStrategy();
        }
    }
}
