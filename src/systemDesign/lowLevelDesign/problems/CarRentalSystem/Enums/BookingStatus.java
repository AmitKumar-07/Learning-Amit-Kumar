package systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums;

public enum BookingStatus {
    CREATED,     // Booking object created but payment not done yet.
    CONFIRMED,   // Payment successful and car is locked for the user.
    IN_PROGRESS, // User has picked up the car; rental is active.
    COMPLETED,   // User returned the car; booking finished successfully.
    CANCELLED ,  // User/system cancelled before pickup; car released.
    FAILED       // Payment or booking validation failed; booking not valid.
}