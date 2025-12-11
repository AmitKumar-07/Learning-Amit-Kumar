package systemDesign.lowLevelDesign.problems.DesignBookMyShow;

import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.SeatType;

public class Seat {

    private String seatId;
    private int row;
    private int seatNumber;
    private SeatType seatType;

    public Seat(String seatId, int row, int seatNumber, SeatType seatType) {
        this.seatId = seatId;
        this.row = row;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
