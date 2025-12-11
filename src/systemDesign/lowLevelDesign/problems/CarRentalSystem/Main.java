package systemDesign.lowLevelDesign.problems.CarRentalSystem;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.BookingStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.CarType;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.PaymentStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.paymentStrategy.PaymentProcessor;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.paymentStrategy.UPIPayment;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //create inventory
        System.out.println("Creating inventory, branches and cars");
        InventoryManager inventory = new InventoryManager();
        Branch b1 = new Branch(1, "Noida Sector 98", "Noida","201304");
        Branch b2 = new Branch(2, "Bhadohi", "Maryad Patti","221401");

        inventory.addBranch(b1);
        inventory.addBranch(b2);

        Car c1 = new Car(101, "UP16 AB 1234", CarType.SEDAN);
        Car c2 = new Car(102, "UP16 XY 7777", CarType.SUV);

        inventory.addCarToBranch(1, c1);
        inventory.addCarToBranch(2, c2);

        CarRentalSystem system = CarRentalSystem.getInstance(inventory);

        // Create users
        User u = new User(1, "Amit Kumar", "DL-12345");
        system.registerUser(u);
        System.out.println("Registered User: "+ u);

        LocalDateTime start = LocalDateTime.now().plusHours(1);
        LocalDateTime end = start.plusHours(4);

        // Search Car
        System.out.println("Searching cars");
        List<Car> result = system.searchCars(2, CarType.SUV, start, end);
        System.out.println("Available SUVs: " + result);

        System.out.println("Booking initiated");
        Car selected = result.get(0); // suppose we choose first car
        Booking booking = system.bookCar(u, selected, start, end);

        System.out.println("stared payment processing for booking: "+ booking);
        PaymentProcessor processor = new PaymentProcessor();
        Payment payment = processor.processPayment(booking, new UPIPayment());
        if(payment.getStatus().equals(PaymentStatus.SUCCESS)){
            booking.setStatus(BookingStatus.CONFIRMED);
            System.out.println("Booking Confirmed: " + booking);
        }else {
            booking.setStatus(BookingStatus.FAILED);
            System.out.println("Payment failed : " + booking);
            System.out.println("Please Complete Payment");
        }

//        System.out.println("************************************");
//
//        LocalDateTime start1 = LocalDateTime.now().plusHours(5);
//        LocalDateTime end1 = start1.plusHours(9);
//
//        // Search Car
//        System.out.println("Searching cars");
//        List<Car> result1 = system.searchCars(2, CarType.SUV, start1, end1);
//        System.out.println("Available SUVs: " + result1);
//
//        System.out.println("Booking initiated");
//        Car selected1 = result1.get(0); // suppose we choose first car
//        Booking booking1 = system.bookCar(u, selected1, start1, end1);
//
//        System.out.println("stared payment processing for booking: "+ booking1);
//        Payment payment1 = processor.processPayment(booking1, new UPIPayment());
//        if(payment1.getStatus().equals(PaymentStatus.SUCCESS)){
//            booking1.setStatus(BookingStatus.CONFIRMED);
//            System.out.println("Booking Confirmed: " + booking1);
//        }else {
//            booking1.setStatus(BookingStatus.FAILED);
//            System.out.println("Payment failed : " + booking1);
//            System.out.println("Please Complete Payment");
//        }
    }
}

