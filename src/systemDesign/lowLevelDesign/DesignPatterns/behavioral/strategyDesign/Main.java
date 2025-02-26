package systemDesign.lowLevelDesign.DesignPatterns.behavioral.strategyDesign;

public class Main {

    public static void main(String[] args){
        Vehicle vehicle = new GoodsVehicle();
        vehicle.drive();
        vehicle = new OffRoadVehicle();
        vehicle.drive();
    }
}
