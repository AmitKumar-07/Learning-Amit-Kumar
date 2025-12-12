package systemDesign.lowLevelDesign.problems.DesignATM;

public class Main {
    public static void main(String args[]) {

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, 112211);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.BALANCE_CHECK);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 1900);
        atmRoom.atm.printCurrentATMStatus();
    }
}
