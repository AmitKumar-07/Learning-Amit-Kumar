package systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign.strategy;

public class SportDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sport Drive Strategy");
    }
}
