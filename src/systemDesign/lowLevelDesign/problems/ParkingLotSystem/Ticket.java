package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.TicketStatus;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;
    private TicketStatus status;
    private String entryGateId;
    private String exitGateId;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public TicketStatus getStatus() { return status; }

    public void markPaid() {
        this.status = TicketStatus.PAID;
    }

    public void setEntryGateId(String entryGateId) {
        this.entryGateId = entryGateId;
    }

    public void setExitGateId(String exitGateId) {
        this.exitGateId = exitGateId;
    }

    public String getEntryGateId() {
        return entryGateId;
    }

    public String getExitGateId() {
        return exitGateId;
    }
}
