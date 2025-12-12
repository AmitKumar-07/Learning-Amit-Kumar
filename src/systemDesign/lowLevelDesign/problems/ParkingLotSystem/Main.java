package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.PaymentMode;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.SpotType;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.strategy.HourlyParkingFeeCalculator;
import systemDesign.lowLevelDesign.problems.ParkingLotSystem.strategy.NearestSpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) {

        // 1. Initialize ParkingLot (Singleton)
        ParkingLot.init(
                "Skymark Parking Lot",
                new NearestSpotAssignmentStrategy(),
                new HourlyParkingFeeCalculator(20)   // ₹20/hour
        );

        ParkingLot parkingLot = ParkingLot.getInstance();

        // 2. Create Floors + Spots
        ParkingFloor floor1 = new ParkingFloor("F1");
        ParkingFloor floor2 = new ParkingFloor("F2");

        //car spots
        floor1.addSpot(new ParkingSpot("C1", SpotType.CAR));
        floor1.addSpot(new ParkingSpot("C2", SpotType.CAR));

        //bike spots
        floor1.addSpot(new ParkingSpot("B1", SpotType.BIKE));
        floor1.addSpot(new ParkingSpot("B2", SpotType.BIKE));

        //Truck spots
        floor2.addSpot(new ParkingSpot("T1", SpotType.TRUCK));
        floor2.addSpot(new ParkingSpot("T2", SpotType.TRUCK));

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        // 3. Gates: Entry & Exist gates are independent to parking lot object
        EntryGate entryGate = new EntryGate("Entry-1");
        ExitGate exitGate = new ExitGate("Exit-1");
        ExitGate exitGate2 = new ExitGate("Exit-2");

        // 4. Vehicle Arrives
        Vehicle car = new Car("UP70AB1234");

        System.out.println("Car arriving...");

        Ticket ticket = entryGate.generateTicket(car);

        System.out.println("Ticket issued:");
        System.out.println("Ticket ID = " + ticket.getTicketId());
        System.out.println("SpotId Assigned = " + ticket.getSpot().getSpotId());
        System.out.println("Entry GateId = " + ticket.getEntryGateId());

        // SIMULATE WAIT TIME (just for example)
        try {
            Thread.sleep(2000);  // 2 seconds (as if the car was parked)
        } catch (Exception ignored) {}

        // 5. Vehicle Exits
        System.out.println("\nCar exiting...");
        Payment payment = exitGate2.processExit(ticket.getTicketId(), PaymentMode.UPI);

        System.out.println("Payment Successful!");
        System.out.println("Amount Paid = ₹" + payment.getAmount());
        System.out.println("SpotId Assigned = " + ticket.getSpot().getSpotId());
        System.out.println("Exist GateId = " + ticket.getExitGateId());

        System.out.println("\nParking Completed.");
    }
}

