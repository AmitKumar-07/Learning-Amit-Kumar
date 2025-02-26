package systemDesign.lowLevelDesign.problems.CarRentalSystem;

public class Payment {

    Bill bill;

    public Payment(Bill bill) {
        this.bill = bill;
    }
    public void payBill() {
        //do payment processing and update the bill status;
    }
}
