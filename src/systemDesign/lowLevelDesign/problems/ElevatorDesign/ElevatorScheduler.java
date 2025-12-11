package systemDesign.lowLevelDesign.problems.ElevatorDesign;
import java.util.List;

public interface ElevatorScheduler {
    ElevatorCar selectElevator(FloorRequest request, List<ElevatorCar> cars);
}
