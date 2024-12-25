package systemDesign.lowLevelDesign.DesignPatterns.factoryMethod;

public class Main {
    public static void main(String[] args) {

        //In factory method design pattern
        //one factory class is responsible for creating only one product type of object.
        VehicleFactory bikeFactory = new BikeFactory();
        Client bikeClient = new Client(bikeFactory);
        bikeClient.getVehicle().run();

        VehicleFactory carFactory = new CarFactory();
        Client carClient = new Client(carFactory);
        carClient.getVehicle().run();
    }
}
