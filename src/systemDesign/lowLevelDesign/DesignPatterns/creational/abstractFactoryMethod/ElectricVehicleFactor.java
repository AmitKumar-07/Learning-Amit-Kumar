package systemDesign.lowLevelDesign.DesignPatterns.creational.abstractFactoryMethod;

public class ElectricVehicleFactor implements VehicleFactory{

    public Vehicle createBike(){
        return new ElectricBike();
    }

    public Vehicle createCar(){
        return new ElectricCar();
    }
}
