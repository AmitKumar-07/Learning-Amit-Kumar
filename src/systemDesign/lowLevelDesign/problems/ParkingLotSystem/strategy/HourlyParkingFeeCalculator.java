package systemDesign.lowLevelDesign.problems.ParkingLotSystem.strategy;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

// Simple hourly calculator
public class HourlyParkingFeeCalculator implements ParkingFeeCalculator {

    private double baseRatePerHour;

    public HourlyParkingFeeCalculator(double baseRatePerHour) {
        this.baseRatePerHour = baseRatePerHour;
    }

    @Override
    public double calculateFee(Ticket ticket)  {
        LocalDateTime in = ticket.getEntryTime();
        LocalDateTime out = LocalDateTime.now();

        long minutes = Duration.between(in, out).toMinutes();
        System.out.println(minutes);
        long hours = (long) Math.ceil(minutes / 60.0);

        if(hours <= 3){
            return baseRatePerHour;
        }
        // You can modify logic by vehicle type etc.
        return hours * baseRatePerHour;
    }
}
