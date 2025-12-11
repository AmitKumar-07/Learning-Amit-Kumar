package systemDesign.lowLevelDesign.problems.ParkingLotSystem.strategy;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.ParkingFloor;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.ParkingSpot;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.Vehicle;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.SpotType;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.VehicleType;

import java.util.List;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot findSpot(Vehicle vehicle, List<ParkingFloor> floors) {
        SpotType requiredType = mapVehicleToSpotType(vehicle.getVehicleType());

        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpotsByType(requiredType)) {
                if (spot.isFree()) {
                    return spot;
                }
            }
        }
        return null; // no spot available
    }

    private SpotType mapVehicleToSpotType(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:  return SpotType.BIKE;
            case CAR:   return SpotType.CAR;
            case TRUCK: return SpotType.TRUCK;
            default:    throw new IllegalArgumentException("Unknown type");
        }
    }
}