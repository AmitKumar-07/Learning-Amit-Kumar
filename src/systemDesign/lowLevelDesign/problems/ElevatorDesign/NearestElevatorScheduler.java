package systemDesign.lowLevelDesign.problems.ElevatorDesign;

import systemDesign.lowLevelDesign.problems.ElevatorDesign.enums.Direction;

import java.util.List;

public class NearestElevatorScheduler implements ElevatorScheduler {

    @Override
    public ElevatorCar selectElevator(FloorRequest request, List<ElevatorCar> cars) {
        int reqFloor = request.getFloor();
        Direction reqDir = request.getDirection();

        ElevatorCar best = null;
        int bestScore = Integer.MAX_VALUE;

        for (ElevatorCar car : cars) {

            int dist = Math.abs(car.getCurrentFloor() - reqFloor), score;

            // CASE 1: Car moving towards the request floor
            if (car.getDirection() == reqDir && ((reqDir == Direction.UP && car.getCurrentFloor() <= reqFloor) ||
                            (reqDir == Direction.DOWN && car.getCurrentFloor() >= reqFloor))) {
                score = dist;  // best case
            } else if (car.getDirection() == Direction.IDLE) {
                score = dist + 2; // little worse than moving-towards
            } else {
                score = dist + 5; // worst: going opposite direction
            }

            if (score < bestScore) {
                bestScore = score;
                best = car;
            }
        }

        return best;
    }
}
