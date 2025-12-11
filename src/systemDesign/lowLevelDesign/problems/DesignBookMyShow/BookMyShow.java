package systemDesign.lowLevelDesign.problems.DesignBookMyShow;

import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.City;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.SeatStatus;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.SeatType;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.service.BookingService;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.service.SeatLockService;

import java.time.LocalDateTime;
import java.util.*;

public class BookMyShow {

    private static BookMyShow instance; // ✅ Singleton instance
    final MovieController movieController;
    final TheatreController theatreController;
    final BookingService bookingService;
    final SeatLockService seatLockService;

    private BookMyShow() { // ✅ Private constructor
        movieController = new MovieController();
        theatreController = new TheatreController();
        this.seatLockService = new SeatLockService();
        this.bookingService = new BookingService(seatLockService);
        initialize();
    }

    public static BookMyShow getInstance() { // ✅ Singleton method
        if (instance == null) {
            instance = new BookMyShow();
        }
        return instance;
    }

    private void initialize() {

        // 1. Create Movies
        Movie avengers = new Movie("M1", "AVENGERS", 170, "English", "Action");
        Movie bahubali = new Movie("M2", "BAHUBALI", 180, "Hindi", "Historical");

        // register movies in MovieController
        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(bahubali, City.Bangalore);
        movieController.addMovie(avengers, City.Delhi);
        movieController.addMovie(bahubali, City.Delhi);

        // 2. Create Seats for screens
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("S1", 1, 1, SeatType.SILVER));
        seats.add(new Seat("S2", 1, 2, SeatType.SILVER));
        seats.add(new Seat("S3", 1, 3, SeatType.GOLD));
        seats.add(new Seat("S4", 1, 4, SeatType.GOLD));

        // 3. Create Screen
        Screen screen1 = new Screen("SC1", "Screen 1", seats);

        // 5. Create Shows for that theatre
        Show showAvenger = new Show("SHOW1", avengers, screen1, LocalDateTime.now().plusHours(1),
                LocalDateTime.now().plusHours(3)
        );
        Show showBahubali = new Show("SHOW2", bahubali, screen1, LocalDateTime.now().plusHours(2),
                LocalDateTime.now().plusHours(5)
        );

        // 6. Create ShowSeats for each Show
        List<ShowSeat> show1Seats = new ArrayList<>();
        for (Seat s : seats) {
            show1Seats.add(new ShowSeat(
                    "SS-" + showAvenger.getShowId() + "-" + s.getSeatId(),
                    showAvenger,
                    s,
                    250.0,
                    SeatStatus.AVAILABLE
            ));
        }

        showAvenger.setShowSeats(show1Seats);

        List<ShowSeat> show2Seats = new ArrayList<>();
        for (Seat s : seats) {
            show2Seats.add(new ShowSeat(
                    "SS-" + showBahubali.getShowId() + "-" + s.getSeatId(),
                    showBahubali,
                    s,
                    350.0,
                    SeatStatus.AVAILABLE
            ));
        }
        showBahubali.setShowSeats(show2Seats);

        // 7. Add shows to theatre
        List<Show> shows = new ArrayList<>();
        shows.add(showAvenger);
        shows.add(showBahubali);


        // 7. Create Theatre (Bangalore)
        Theatre inoxBlr = new Theatre("T1", "INOX Bangalore", "Koramangala", City.Bangalore,
                Collections.singletonList(screen1));

        Theatre pvrDelhi = new Theatre("T2", "PVR DELHI", "civil lines", City.Delhi,
                Collections.singletonList(screen1));
        inoxBlr.setShows(shows);
        pvrDelhi.setShows(shows);

        // register theatre
        theatreController.addTheatre(inoxBlr, City.Bangalore);
        theatreController.addTheatre(pvrDelhi, City.Delhi);

        System.out.println("BookMyShow initialized successfully with movies, theatre, screens & shows.");
    }

}
