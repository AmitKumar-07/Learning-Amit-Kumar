package systemDesign.lowLevelDesign.problems.ElevatorDesign;

import systemDesign.lowLevelDesign.problems.ElevatorDesign.enums.Direction;

public class ElevatorDisplay {

    int floor;
    Direction direction;

    public void setDisplay(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public void showDisplay(){
        System.out.println("Floor : " + floor + ", Direction : " + direction);
    }
}
