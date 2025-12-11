package systemDesign.lowLevelDesign.problems.CarRentalSystem;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.BookingStatus;
import java.time.LocalDateTime;

public class Booking {

    private String bookingId;
    private User user;
    private Car car;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double amount;
    private BookingStatus status;

    public Booking(String bookingId, User user, Car car,
                   LocalDateTime startTime, LocalDateTime endTime,
                   double amount) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
        this.status = BookingStatus.CREATED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public double getAmount() {
        return amount;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{id=" + bookingId +
                ", user=" + user.getName() +
                ", car=" + car.getNumberPlate() +
                ", start=" + startTime +
                ", end=" + endTime +
                ", amount=" + amount +
                ", status=" + status + "}";
    }
}
