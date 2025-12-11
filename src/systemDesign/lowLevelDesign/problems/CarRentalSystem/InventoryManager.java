package systemDesign.lowLevelDesign.problems.CarRentalSystem;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.CarType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class InventoryManager {

    private Map<Integer, Branch> branches = new HashMap<>();

    public void addBranch(Branch branch) {
        branches.put(branch.getBranchId(), branch);
    }

    public void addCarToBranch(int branchId, Car car) {
        branches.get(branchId).addCar(car);
    }

    public List<Car> getCarsByType(int branchId, CarType type) {
        return branches.get(branchId)
                .getCars()
                .stream()
                .filter(c -> c.getCarType() == type)
                .collect(Collectors.toList());
    }
}