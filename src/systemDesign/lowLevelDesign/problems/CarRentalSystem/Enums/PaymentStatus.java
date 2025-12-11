package systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums;

public enum PaymentStatus {
    PENDING,  // Payment initiated but not completed yet.
    SUCCESS,  // Payment completed successfully.
    FAILED,   // Payment failed due to error/insufficient funds.
    REFUNDED  // Amount returned to the user after cancellation.
}