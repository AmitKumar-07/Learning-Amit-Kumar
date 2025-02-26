package systemDesign.lowLevelDesign.DesignPatterns.creational.factoryMethod;

public class CarFactory implements VehicleFactory{

    public Vehicle createVehicle(){
        return new Car();
    }
}
