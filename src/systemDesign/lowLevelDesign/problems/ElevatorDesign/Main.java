package systemDesign.lowLevelDesign.problems.ElevatorDesign;
import systemDesign.lowLevelDesign.problems.ElevatorDesign.enums.Direction;

public class Main {
    public static void main(String[] args) throws Exception{

        // Create an Elevator System with 2 elevators starting at floor 0
        ElevatorSystem system = new ElevatorSystem(2, 0, 6);

        // --- External Requests (From building floors) ---
        system.handleExternalRequest(5, Direction.UP); // Someone at floor 5 pressed UP
        system.handleExternalRequest(2, Direction.DOWN); // Someone at floor 2 pressed DOWN

        // --- Internal Requests (From inside elevator cabin) ---
        system.handleInternalRequest(1, 4); // Inside elevator 0, someone pressed floor 4 & 7
        system.handleInternalRequest(1, 7);

        // --- Simulate movement for 15 time steps ---
        for (int i = 0; i < 15; i++) {
            system.step();

            if(i==2){
                system.handleInternalRequest(1, 1);
            } else if(i==10){
                system.handleInternalRequest(1,5);
            }
            // Print current status of each elevator
            for (ElevatorCar car : system.getCars()) {
                System.out.println(
                        "Elevator " + car.getId() +
                                " | Floor: " + car.getCurrentFloor() +
                                " | Direction: " + car.getDirection() +
                                " | State: " + car.getState()
                );
            }
            System.out.println("---------------------------------------");
        }

        /*Elevator Algo
        ✅ 1. SCAN Algorithm (when clicked from inside the elevator): Elevator moves in one direction, serves all requests on the way,
        then reverses direction — like scanning floors. This avoids back-tracking & zig-zag movement.
        ✅ 2. LOOK Algorithm (when clicked from inside the elevator) : Same as SCAN, but the elevator only goes as far as needed, not till top/bottom.
        ✅ 3. Nearest Car Algorithm (when clicked from outside the elevator): Select the elevator that is best positioned to serve the floor request.
        Current direction of elevator
        Whether the elevator will naturally pass that floor
        Distance from request floor
        Choose the elevator closest to that floor and already moving towards it. If none are moving correctly, pick the nearest idle one.

        SCAN/LOOK only decides the order, NOT actual movement. If SCAN does not move the elevator, then who moves it?
        step() and updateDirection() = Simulation Engine, These methods are NOT the algorithm They are just “execution engine” to simulate movement.
        ✔ What does step() do?
            Increment (if going up)
            Decrement (if going down)
            Check if this floor is in stop list → open door
            Remove that stop
            Ask updateDirection() if direction needs to be changed
        ✔ What does updateDirection() do?
        It checks:
            Are there more UP stops? continue UP
            If UP stops empty but DOWN stops exist → reverse
            If both empty → idle
        */
    }
}
