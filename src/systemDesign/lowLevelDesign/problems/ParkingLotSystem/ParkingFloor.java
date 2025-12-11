package systemDesign.lowLevelDesign.problems.ParkingLotSystem;

import systemDesign.lowLevelDesign.problems.ParkingLotSystem.enums.SpotType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private String floorId;
    // group spots by type for fast searching
    private final Map<SpotType, List<ParkingSpot>> spotsByType = new HashMap<>();

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        for (SpotType type : SpotType.values()) {
            spotsByType.put(type, new ArrayList<>());
        }
    }

    public void addSpot(ParkingSpot spot) {
        spotsByType.get(spot.getSpotType()).add(spot);
    }

    public List<ParkingSpot> getSpotsByType(SpotType type) {
        return spotsByType.get(type);
    }

    public String getFloorId() {
        return floorId;
    }
}
