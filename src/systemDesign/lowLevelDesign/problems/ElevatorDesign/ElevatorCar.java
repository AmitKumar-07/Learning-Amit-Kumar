package systemDesign.lowLevelDesign.problems.ElevatorDesign;

import systemDesign.lowLevelDesign.problems.ElevatorDesign.enums.Direction;
import systemDesign.lowLevelDesign.problems.ElevatorDesign.enums.ElevatorState;

import java.util.TreeSet;

public class ElevatorCar {

    private int id;
    private int currentFloor;
    private int maxFloor;
    private Direction direction;
    private ElevatorState state;

    // floors to stop while going up / down
    private TreeSet<Integer> upStops = new TreeSet<>();
    private TreeSet<Integer> downStops = new TreeSet<>((a, b) -> b - a);

    public ElevatorCar(int id, int startFloor, int maxFloor) {
        this.id = id;
        this.currentFloor = startFloor;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.maxFloor = maxFloor;
    }

    public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
    public ElevatorState getState() { return state; }

    // Called when someone inside this car presses a floor button
    public void addInternalRequest(CabinRequest request) {
        int floor = request.getFloor();
        if (floor == currentFloor) return;

        if (floor > currentFloor) {
            upStops.add(floor);
        } else {
            downStops.add(floor);
        }
        updateDirection();
    }

    // Called by scheduler when this car is chosen to serve a floor request
    public void addExternalRequest(FloorRequest request) {
        int floor = request.getFloor();
        if (floor == currentFloor) return;

        if (floor > currentFloor) {
            upStops.add(floor);
        } else {
            downStops.add(floor);
        }
        updateDirection();
    }

    //step and updateDirection method behaving like Look Algo
    private void updateDirection() {

        // Case 1: Elevator is moving UP
        if (direction == Direction.UP) {
            if (!upStops.isEmpty()) {
                return; // continue UP
            }
            // no more UP requests → check DOWN queue
            if (!downStops.isEmpty()) {
                direction = Direction.DOWN; // reverse
            } else {
                direction = Direction.IDLE;
                state = ElevatorState.IDLE;
            }
            return;
        }

        // Case 2: Elevator is moving DOWN
        if (direction == Direction.DOWN) {
            if (!downStops.isEmpty()) {
                return; // continue DOWN
            }
            // no more DOWN requests → check UP queue
            if (!upStops.isEmpty()) {
                direction = Direction.UP; // reverse
            } else {
                direction = Direction.IDLE;
                state = ElevatorState.IDLE;
            }
            return;
        }

        // Case 3: Elevator is IDLE
        if (direction == Direction.IDLE) {
            if (!upStops.isEmpty()) {
                direction = Direction.UP;
            } else if (!downStops.isEmpty()) {
                direction = Direction.DOWN;
            } else {
                direction = Direction.IDLE; // nothing to do
            }
        }
    }

    // Simulate one time-step movement
    public void step() throws Exception {

        if (direction == Direction.IDLE)
            return;

        // Boundary protection (optional for LOOK)
        if (direction == Direction.UP && currentFloor == maxFloor) {
            direction = Direction.DOWN;
            return;
        }

        if (direction == Direction.DOWN && currentFloor == 0) {
            direction = Direction.UP;
            return;
        }

        state = ElevatorState.MOVING;

        // Move 1 floor
        if (direction == Direction.UP) {
            currentFloor++;

            if (upStops.contains(currentFloor)) {
                openDoor();
                upStops.remove(currentFloor);
            }
        }

        else if (direction == Direction.DOWN) {
            currentFloor--;

            if (downStops.contains(currentFloor)) {
                openDoor();
                downStops.remove(currentFloor);
            }
        }

        // Recalculate direction using LOOK logic
        updateDirection();
    }

    private void openDoor() throws Exception{
        System.out.println("Elevator " + id + " opening door at floor " + currentFloor);
        // open door, wait, close door
        // (we can model Door class separately if needed)
        // for LLD, just assume it happens.
        Thread.sleep(500);
        System.out.println("Elevator " + id + " closing door at floor " + currentFloor);
    }

}
