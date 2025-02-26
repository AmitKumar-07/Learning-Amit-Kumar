package systemDesign.lowLevelDesign.DesignPatterns.creational.abstractFactoryMethod;

public class PetrolVehicleFactory implements VehicleFactory{

    public Vehicle createBike(){
        return new PetrolBike();
    }

    public Vehicle createCar(){
        return new PetrolCar();
    }
}
