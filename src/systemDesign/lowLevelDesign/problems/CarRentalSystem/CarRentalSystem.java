package systemDesign.lowLevelDesign.problems.CarRentalSystem;

import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.CarStatus;
import systemDesign.lowLevelDesign.problems.CarRentalSystem.Enums.CarType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CarRentalSystem {
    private static CarRentalSystem instance;
    private InventoryManager inventoryManager;
    private BookingManager bookingManager;
    private Map<Integer, User> users;

    private CarRentalSystem(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.bookingManager = new BookingManager();
        this.users = new HashMap<>();
    }

    public static synchronized CarRentalSystem getInstance(InventoryManager inventoryManager) {
        if (instance == null) {
            instance = new CarRentalSystem(inventoryManager);
        }
        return instance;
    }

    public List<Car> searchCars(int branchId, CarType type,
                                LocalDateTime start, LocalDateTime end) {

        List<Car> cars = inventoryManager.getCarsByType(branchId, type);

        List<Car> available = new ArrayList<>();
        for (Car c : cars) {
            if (c.getStatus() != CarStatus.UNDER_MAINTENANCE &&
                    bookingManager.isAvailable(c, start, end)) {
                available.add(c);
            }
        }
        return available;
    }

    public Booking bookCar(User user, Car car,
                           LocalDateTime start, LocalDateTime end) {

        return bookingManager.createBooking(user, car, start, end);
    }

    public void registerUser(User user){
        int userID = user.getUserId();
        if(users.containsKey(userID)){
            System.out.println("User with id : " + userID + "Already exists in the system");
            return;
        }
        users.put(userID , user);
    }
}
