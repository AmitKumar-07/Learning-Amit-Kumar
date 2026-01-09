package systemDesign.lowLevelDesign.problems.DesignATM.ATMStates;

import systemDesign.lowLevelDesign.problems.DesignATM.ATM;
import systemDesign.lowLevelDesign.problems.DesignATM.AmountWithdrawal.CashWithdrawProcessor;
import systemDesign.lowLevelDesign.problems.DesignATM.AmountWithdrawal.FiveHundredWithdrawProcessor;
import systemDesign.lowLevelDesign.problems.DesignATM.AmountWithdrawal.OneHundredWithdrawProcessor;
import systemDesign.lowLevelDesign.problems.DesignATM.AmountWithdrawal.TwoThousandWithdrawProcessor;
import systemDesign.lowLevelDesign.problems.DesignATM.Card;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    @Override
    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest) {

        if (atmObject.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {

            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.deductATMBalance(withdrawalAmountRequest);

            //using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs notes etc, has to be withdrawal
            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            exit(atmObject);
        }
    }
}
