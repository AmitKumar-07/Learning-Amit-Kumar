package systemDesign.lowLevelDesign.problems.ParkingLotSystem.strategy;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.ParkingFloor;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.ParkingSpot;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.Vehicle;

import java.util.List;

public interface SpotAssignmentStrategy {
    ParkingSpot findSpot(Vehicle vehicle, List<ParkingFloor> floors);
}
