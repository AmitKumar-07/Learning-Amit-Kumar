package systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign;

import systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

    public GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
