package systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign;
import systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign.strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle{


    public OffRoadVehicle() {
        super(new SportDriveStrategy());
    }
}
