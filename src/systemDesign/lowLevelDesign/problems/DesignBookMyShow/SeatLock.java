package systemDesign.lowLevelDesign.problems.DesignBookMyShow;

import java.time.LocalDateTime;

public class SeatLock {

    private ShowSeat showSeat;
    private User user;
    private LocalDateTime lockTime;
    private LocalDateTime expiryTime;

    public SeatLock(ShowSeat showSeat, User user, LocalDateTime lockTime, LocalDateTime expiryTime) {
        this.showSeat = showSeat;
        this.user = user;
        this.lockTime = lockTime;
        this.expiryTime = expiryTime;
    }

    public ShowSeat getShowSeat() {
        return showSeat;
    }

    public void setShowSeat(ShowSeat showSeat) {
        this.showSeat = showSeat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
