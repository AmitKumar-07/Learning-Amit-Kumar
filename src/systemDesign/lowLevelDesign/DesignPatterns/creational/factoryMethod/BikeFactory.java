package systemDesign.lowLevelDesign.DesignPatterns.creational.factoryMethod;

public class BikeFactory implements VehicleFactory{

    public Vehicle createVehicle(){
        return new Bike();
    }
}
