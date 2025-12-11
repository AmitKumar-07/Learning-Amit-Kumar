package systemDesign.lowLevelDesign.problems.ElevatorDesign;

import systemDesign.lowLevelDesign.problems.ElevatorDesign.enums.Direction;

// External request: from a floor (hall button)
public class FloorRequest {
    private int floor;
    private Direction direction;  // UP or DOWN

    public FloorRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() { return floor; }
    public Direction getDirection() { return direction; }
}
