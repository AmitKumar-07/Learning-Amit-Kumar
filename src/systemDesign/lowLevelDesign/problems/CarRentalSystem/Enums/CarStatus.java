package systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums;

public enum CarStatus {
    AVAILABLE,          // car physically present in branch
    IN_USE,             // user is currently driving it
    UNDER_MAINTENANCE   // car not available physically
}
/* CarStatus should NOT depend on future bookings, CarStatus should depend ONLY on current physical usage*/