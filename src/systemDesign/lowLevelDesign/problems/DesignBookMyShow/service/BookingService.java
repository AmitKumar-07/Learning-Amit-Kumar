package systemDesign.lowLevelDesign.problems.DesignBookMyShow.service;

import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Booking;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.BookingStatus;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Show;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.ShowSeat;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.User;

import java.util.List;
import java.util.UUID;

public class BookingService {

    private final SeatLockService seatLockService;

    public BookingService(SeatLockService seatLockService) {
        this.seatLockService = seatLockService;
    }

    public Booking createBooking(User user, Show show, List<ShowSeat> seats) {

        // 1. Try to lock seats
        boolean locked = seatLockService.lockSeats(user, seats);
        if (!locked) {
            throw new RuntimeException("Seat already locked by someone else");
        }

        // 2. Create pending booking
        Booking booking = new Booking();
        booking.setBookingId(UUID.randomUUID().toString());
        booking.setUser(user);
        booking.setShow(show);
        booking.setSeats(seats);
        booking.setStatus(BookingStatus.PENDING);

        // Calculate amount
        double total = seats.stream()
                .mapToDouble(showSeat -> showSeat.getPrice())
                .sum();
        booking.setTotalAmount(total);
        return booking;
    }
}
