package systemDesign.lowLevelDesign.problems.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private int branchId;
    private String name;
    private String address;
    private String pincode;
    private List<Car> cars;

    public Branch(int branchId, String name, String address, String pincode) {
        this.branchId = branchId;
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.cars = new ArrayList<>();
    }

    public int getBranchId() {
        return branchId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
        car.setBranch(this);
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Branch{id=" + branchId + ", name=" + name + "}";
    }
}
