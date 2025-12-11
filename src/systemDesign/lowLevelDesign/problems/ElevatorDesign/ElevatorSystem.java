package systemDesign.lowLevelDesign.problems.ElevatorDesign;

import systemDesign.lowLevelDesign.problems.ElevatorDesign.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {

    private int totalFloors;
    private List<ElevatorCar> cars = new ArrayList<>();
    private ElevatorScheduler scheduler;

    public ElevatorSystem(int numCars, int initialFloor, int totalFloors) {
        this.totalFloors = totalFloors;
        this.scheduler = new NearestElevatorScheduler();
        for (int i = 0; i < numCars; i++) {
            cars.add(new ElevatorCar(i, initialFloor, totalFloors));
        }
    }

    // called when someone presses hall button at a floor
    public void handleExternalRequest(int floor, Direction direction) {
        if (floor < 0 || floor > totalFloors) {
            System.out.println(floor + " is Invalid floor");
            return;
        }
        FloorRequest request = new FloorRequest(floor, direction);
        ElevatorCar chosen = scheduler.selectElevator(request, cars);
        if (chosen != null) {
            chosen.addExternalRequest(request);
        }
    }

    // called when someone inside a car presses a floor number
    public void handleInternalRequest(int elevatorId, int floor) {
        if (floor < 0 || floor > totalFloors) {
            System.out.println(floor + " is Invalid floor");
            return;
        }
        CabinRequest request = new CabinRequest(floor);
        cars.get(elevatorId).addInternalRequest(request);
    }

    // simulate movement for all cars (one time-step)
    public void step() throws Exception{
        for (ElevatorCar car : cars) {
            car.step();
        }
    }

    public List<ElevatorCar> getCars() {
        return cars;
    }
}
