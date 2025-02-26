package systemDesign.lowLevelDesign.DesignPatterns.creational.factoryMethod;

public class Main {
    public static void main(String[] args) {

        //In factory method design pattern
        //one factory class is responsible for creating only one product type of object.
        VehicleFactory bikeFactory = new BikeFactory();
        Vehicle vehicle = bikeFactory.createVehicle();
        vehicle.run();



        VehicleFactory carFactory = new CarFactory();
        Vehicle vehicle1 = carFactory.createVehicle();
        vehicle1.run();
    }
}
