package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.SpotType;

public class ParkingSpot {
    private String spotId;
    private SpotType spotType;
    private boolean isFree;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public String getSpotId() {
        return spotId;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isFree = false;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isFree = true;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
