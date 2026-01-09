package systemDesign.lowLevelDesign.problems.DesignATM.ATMStates;

import systemDesign.lowLevelDesign.problems.DesignATM.ATM;
import systemDesign.lowLevelDesign.problems.DesignATM.Card;
import systemDesign.lowLevelDesign.problems.DesignATM.TransactionType;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(ATM atm, Card card, int pin){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount){
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    // Common method - handles card return and state transition to Idle
    public void exit(ATM atm){
        System.out.println("Please collect your card");
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }
}
