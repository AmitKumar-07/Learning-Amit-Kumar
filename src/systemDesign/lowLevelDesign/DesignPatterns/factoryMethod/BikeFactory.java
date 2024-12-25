package systemDesign.lowLevelDesign.DesignPatterns.factoryMethod;

public class BikeFactory implements VehicleFactory{

    public Vehicle createVehicle(){
        return new Bike();
    }
}
