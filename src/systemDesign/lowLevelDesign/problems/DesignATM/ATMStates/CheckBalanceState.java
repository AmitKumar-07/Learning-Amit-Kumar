package systemDesign.lowLevelDesign.problems.DesignATM.ATMStates;

import systemDesign.lowLevelDesign.problems.DesignATM.ATM;
import systemDesign.lowLevelDesign.problems.DesignATM.Card;

public class CheckBalanceState extends ATMState{

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your Balance is: " + card.getBankBalance());
        exit(atm);
    }
}
