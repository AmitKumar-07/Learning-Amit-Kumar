package systemDesign.lowLevelDesign.problems.SnakeLadder;

public class Player {

    String name;
    int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public void setCurrentPosition(int pos) {
        this.currentPosition = pos;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public String getName(){
        return name;
    }
}
