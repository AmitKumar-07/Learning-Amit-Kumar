package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

public abstract class Gate {
    protected String gateId;

    public Gate(String gateId) {
        this.gateId = gateId;
    }

    public String getGateId() {
        return gateId;
    }
}
