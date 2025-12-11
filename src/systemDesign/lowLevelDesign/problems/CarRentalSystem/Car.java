package systemDesign.lowLevelDesign.problems.CarRentalSystem;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.CarStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.CarType;

public class Car {
    private int carId;
    private String numberPlate;
    private CarType carType;
    private CarStatus status;
    private Branch branch;  // owning branch

    public Car(int carId, String numberPlate, CarType carType) {
        this.carId = carId;
        this.numberPlate = numberPlate;
        this.carType = carType;
        this.status = CarStatus.AVAILABLE;
    }

    public int getCarId() {
        return carId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public CarType getCarType() {
        return carType;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Car{id=" + carId + ", plate=" + numberPlate + ", type=" + carType + ", status=" + status + "}";
    }
}
