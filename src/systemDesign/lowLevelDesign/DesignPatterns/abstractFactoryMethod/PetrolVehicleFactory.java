package systemDesign.lowLevelDesign.DesignPatterns.abstractFactoryMethod;

public class PetrolVehicleFactory implements VehicleFactory{

    public Vehicle createBike(){
        return new PetrolBike();
    }

    public Vehicle createCar() {
        return new PetrolCar();
    }
}
