package systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.impl;

import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingMachine;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.State;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums.Coin;

public class IdleState implements State {

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) throws Exception{
        vm.addCoin(coin);
        vm.setState(new HasMoneyState());
        System.out.println("Coin inserted: " + coin.getValue());
    }

    @Override
    public void selectItem(VendingMachine vm, int code) {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void dispense(VendingMachine vm) throws Exception{
        System.out.println("No money, cannot dispense anything.");
    }

}
