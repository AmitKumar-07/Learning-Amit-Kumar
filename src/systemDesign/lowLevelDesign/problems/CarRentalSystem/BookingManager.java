package systemDesign.lowLevelDesign.problems.CarRentalSystem;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.BookingStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.pricingStrategy.PricingStrategy;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.pricingStrategy.PricingStrategyFactory;

import java.time.LocalDateTime;
import java.util.*;

class BookingManager {

    private Map<Integer, List<Booking>> carBookings = new HashMap<>();
    public boolean isAvailable(Car car, LocalDateTime start, LocalDateTime end) {
        List<Booking> list = carBookings.get(car.getCarId());
        if (list == null) return true;

        for (Booking b : list) {
            boolean overlapping =
                    !(end.isBefore(b.getStartTime()) || start.isAfter(b.getEndTime()));
            if (overlapping) return false;
        }
        return true;
    }

    public Booking createBooking(User user, Car car,
                                 LocalDateTime start, LocalDateTime end) {

        if (!isAvailable(car, start, end))
            throw new RuntimeException("Car unavailable");

        PricingStrategy pricingStrategy = PricingStrategyFactory.chooseStrategy(start, end);
        double amount = pricingStrategy.calculatePrice(car, start, end);

        Booking booking =
                new Booking(UUID.randomUUID().toString(), user, car, start, end, amount);

        carBookings.computeIfAbsent(car.getCarId(), k -> new ArrayList<>())
                .add(booking);

        booking.setStatus(BookingStatus.CREATED);
        return booking;
    }
}

