package systemDesign.lowLevelDesign.problems.ParkingLotSystem.strategy;


import systemDesign.lowLevelDesign.problems.ParkingLotSystem.Ticket;

public interface ParkingFeeCalculator {
    double calculateFee(Ticket ticket);
}
