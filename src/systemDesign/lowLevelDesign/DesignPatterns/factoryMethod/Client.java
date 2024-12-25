package systemDesign.lowLevelDesign.DesignPatterns.factoryMethod;

public class Client {

    private Vehicle vehicle;

    Client(VehicleFactory vehicleFactory){
        this.vehicle=vehicleFactory.createVehicle();
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
}
