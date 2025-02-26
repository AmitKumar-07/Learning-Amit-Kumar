package systemDesign.lowLevelDesign.problems.CarRentalSystem;


import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enum.ReservationStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enum.ReservationType;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Product.Vehicle;

import java.util.Date;

public class Reservation {

    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location location;

    public void createReserve(User user, Vehicle vehicle){

        //generate new id
        reservationId = 12232;
        this.user=user;
        this.vehicle=vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
    }

    // CRUD operations

}
