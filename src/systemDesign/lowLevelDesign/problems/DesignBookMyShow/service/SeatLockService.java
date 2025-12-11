package systemDesign.lowLevelDesign.problems.DesignBookMyShow.service;

import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.SeatStatus;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.SeatLock;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.ShowSeat;
import systemDesign.lowLevelDesign.problems.DesignBookMyShow.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatLockService {

    private final Map<ShowSeat, SeatLock> locks = new HashMap<>();
    private final long lockTimeoutSeconds = 300; // 5 minutes

    public synchronized boolean lockSeats(User user, List<ShowSeat> seats) {
        for (ShowSeat s : seats) {
            if (isSeatLocked(s)) return false;   // someone else locked
        }

        LocalDateTime now = LocalDateTime.now();

        for (ShowSeat s : seats) {
            SeatLock lock = new SeatLock(s, user, now, now.plusSeconds(lockTimeoutSeconds));
            locks.put(s, lock);
            s.setStatus(SeatStatus.LOCKED);
        }
        return true;
    }

    public boolean isSeatLocked(ShowSeat seat) {
        SeatLock lock = locks.get(seat);
        if (lock == null) return false;

        // check expiry
        if (lock.getExpiryTime().isBefore(LocalDateTime.now())) {
            locks.remove(seat);
            seat.setStatus(SeatStatus.AVAILABLE);
            return false;
        }
        return true;
    }

}
