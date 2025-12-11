package systemDesign.lowLevelDesign.problems.ParkingLotSystem;


public class EntryGate extends Gate {

    public EntryGate(String gateId) {
        super(gateId);
    }

    public Ticket generateTicket(Vehicle vehicle) {
        return ParkingLot.getInstance().parkVehicle(vehicle, gateId);
    }
}
