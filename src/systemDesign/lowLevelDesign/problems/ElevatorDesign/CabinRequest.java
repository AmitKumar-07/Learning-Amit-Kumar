package systemDesign.lowLevelDesign.problems.ElevatorDesign;

// Internal request: from inside the elevator car
public class CabinRequest {
    private int floor;

    public CabinRequest(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }
}