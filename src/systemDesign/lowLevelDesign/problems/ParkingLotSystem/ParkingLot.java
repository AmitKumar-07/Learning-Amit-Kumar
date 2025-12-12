package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.PaymentMode;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.strategy.ParkingFeeCalculator;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.strategy.SpotAssignmentStrategy;

import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;

    private String name;
    private List<ParkingFloor> floors = new ArrayList<>();
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingFeeCalculator feeCalculator;
    private Map<String, Ticket> activeTickets = new HashMap<>(); // ticketId -> Ticket

    private ParkingLot(String name,
                       SpotAssignmentStrategy spotAssignmentStrategy,
                       ParkingFeeCalculator feeCalculator) {
        this.name = name;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.feeCalculator = feeCalculator;
    }

    public static void init(String name,
                            SpotAssignmentStrategy spotStrategy,
                            ParkingFeeCalculator feeCalculator) {
        if (instance == null) {
            instance = new ParkingLot(name, spotStrategy, feeCalculator);
        }
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ParkingLot not initialized");
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle, String gateId) {
        ParkingSpot spot = spotAssignmentStrategy.findSpot(vehicle, floors);
        if (spot == null) {
            throw new RuntimeException("No spot available");
        }
        spot.parkVehicle(vehicle);
        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle, spot);
        ticket.setEntryGateId(gateId);
        activeTickets.put(ticketId, ticket);
        return ticket;
    }

    public Payment unparkVehicle(String ticketId, PaymentMode paymentMode, String gateId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            throw new RuntimeException("Invalid ticket");
        }

        double amount = feeCalculator.calculateFee(ticket);
        Payment payment = new Payment(UUID.randomUUID().toString(), paymentMode, amount);
        payment.markSuccess();  // Assume always success for LLD

        ticket.getSpot().removeVehicle();
        ticket.markPaid();
        ticket.setExitGateId(gateId);
        activeTickets.remove(ticketId);
        return payment;
    }
}
