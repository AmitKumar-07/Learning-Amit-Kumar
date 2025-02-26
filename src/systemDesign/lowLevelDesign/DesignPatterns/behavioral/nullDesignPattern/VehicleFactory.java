package systemDesign.lowLevelDesign.DesignPatterns.behavioral.nullDesignPattern;

public class VehicleFactory {


    static Vehicle getVehicleObject(String vehicleType){

        if("Car".equals(vehicleType)) {
            return new Car();
        }
        return new NullVehicle();
    }
}
