package systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.impl;

import systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums.Coin;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingMachine;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.State;

public class HasMoneyState implements State {

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) throws Exception{
        vm.addCoin(coin);
        System.out.println("Coin inserted: " + coin.getValue());
    }

    @Override
    public void selectItem(VendingMachine vm, int code) throws Exception {
        vm.setSelectedCode(code);
        vm.setState(new SelectionState());
        System.out.println("Item selected with code: " + code);
    }

    @Override
    public void dispense(VendingMachine vm) throws Exception{
        System.out.println("Please select item first.");
    }
}
