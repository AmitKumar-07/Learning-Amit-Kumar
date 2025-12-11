package systemDesign.lowLevelDesign.problems.DesignBookMyShow;

import java.util.List;

public class Screen {

    String screenId;
    String name;
    List<Seat> seats;

    public Screen(String screenId, String name, List<Seat> seats) {
        this.screenId = screenId;
        this.name = name;
        this.seats = seats;
    }

    //Getter Setter
}
