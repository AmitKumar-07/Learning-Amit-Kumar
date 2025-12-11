package systemDesign.lowLevelDesign.problems.DesignBookMyShow;

import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.BookingStatus;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.City;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.PaymentStatus;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.SeatStatus;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.service.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        BookMyShow bookMyShow = BookMyShow.getInstance();

        //Search Movies List in a City
        bookMyShow.movieController.getMoviesByCity(City.Delhi);

        //Select interested Movie
        Movie interestedMovie = bookMyShow.movieController.getMovieByName("BAHUBALI");

        //All theatre along with list of show for interested movie
        Map<Theatre, List<Show>> allTheatreVsShows = bookMyShow.theatreController.getAllShow(interestedMovie, City.Delhi);

        //select theatre and show;
        String theatreName = "PVR DELHI";
        Theatre theatreByName = bookMyShow.theatreController.getTheatreByName(allTheatreVsShows, theatreName);
        List<Show> shows = theatreByName.getShows();
        Show show = shows.get(0);

        //select seats for booking
        List<ShowSeat> selectedSeats = new ArrayList<>();
        selectedSeats.add(show.getShowSeats().get(0));
        selectedSeats.add(show.getShowSeats().get(1));

        User user = new User("U1", "Amit", "amit@gmail.com");

        Booking booking = bookMyShow.bookingService.createBooking(user, show, selectedSeats);

        System.out.println("Booking created: " + booking.getBookingId() + " | Status: " + booking.getStatus());
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.initiatePayment(booking, "UPI");
        if (PaymentStatus.INITIATED.equals(payment.getStatus())) {
            booking.setStatus(BookingStatus.CONFIRMED);
            paymentService.updatePaymentStatus(payment.getPaymentId(), PaymentStatus.SUCCESS, payment);
            // mark seats as BOOKED
            for (ShowSeat ss : selectedSeats) {
                ss.setStatus(SeatStatus.BOOKED);
            }
            System.out.println("Payment successful! Booking CONFIRMED");
        }
        else {
            booking.setStatus(BookingStatus.CANCELLED);
            paymentService.updatePaymentStatus(payment.getPaymentId(), PaymentStatus.FAILED, payment);
            for (ShowSeat ss : selectedSeats) {
                ss.setStatus(SeatStatus.AVAILABLE);
            }
            System.out.println("Payment failed. Booking CANCELLED");
        }
    }
}
