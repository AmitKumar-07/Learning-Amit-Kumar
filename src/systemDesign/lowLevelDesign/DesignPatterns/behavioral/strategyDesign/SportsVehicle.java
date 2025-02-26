package systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign.strategy.SportDriveStrategy;

public class SportsVehicle extends Vehicle{

    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
