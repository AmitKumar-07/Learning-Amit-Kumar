package systemDesign.lowLevelDesign.problems.DesignBookMyShow;

import systemDesign.lowLevelDesign.problems.DesignBookMyShow.Enums.SeatStatus;

public class ShowSeat {

    String id;
    Show show;
    Seat seat;
    double price;
    SeatStatus status;

    public ShowSeat(String id, Show show, Seat seat, double price, SeatStatus status) {
        this.id = id;
        this.show = show;
        this.seat = seat;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
