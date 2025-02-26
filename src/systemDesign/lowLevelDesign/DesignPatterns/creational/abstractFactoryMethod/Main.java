package systemDesign.lowLevelDesign.DesignPatterns.creational.abstractFactoryMethod;

public class Main {

    public static void main(String[] args) {

        //In abstract factory method design pattern
        // one factory class is responsible for creating product of related type of object.
        //for example electricFactory class is responsible for creating object of bike(2 wheeler)
        // and car (4 wheeler) as well

        ElectricVehicleFactor electricVehicleFactor = new ElectricVehicleFactor();
        electricVehicleFactor.createBike().run();
        electricVehicleFactor.createCar().run();

        PetrolVehicleFactory petrolVehicleFactory = new PetrolVehicleFactory();
        petrolVehicleFactory.createBike().run();
        petrolVehicleFactory.createCar().run();
    }
}
