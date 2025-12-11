package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

