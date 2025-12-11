package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.PaymentMode;

public class ExitGate extends Gate {

    public ExitGate(String gateId) {
        super(gateId);
    }

    public Payment processExit(String ticketId, PaymentMode mode) {
        return ParkingLot.getInstance().unparkVehicle(ticketId, mode, gateId);
    }
}
