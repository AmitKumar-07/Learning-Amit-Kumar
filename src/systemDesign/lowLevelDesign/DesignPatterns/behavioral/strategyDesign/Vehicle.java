package systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign.strategy.DriveStrategy;

public class Vehicle {

    private DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }
}
