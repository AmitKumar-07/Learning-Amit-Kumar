package systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.impl;

import systemDesign.lowLevelDesign.problems.DesignVendingMachine.Item;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingMachine;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.State;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums.Coin;

public class DispenseState implements State {

    private final Item item;

    public DispenseState(Item item) {
        this.item = item;
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {

    }

    @Override
    public void selectItem(VendingMachine vm, int code) {

    }

    @Override
    public void dispense(VendingMachine vm) throws Exception {

        System.out.println("Dispensing: " + item.getType());

        int change = vm.getTotalMoney() - item.getPrice();

        // Clear coins
        vm.getCoinList().clear();

        if (change > 0) {
            System.out.println("Returning change: " + change);
        }

        // go back to idle
        vm.setState(new IdleState());
        System.out.println("Back to Idle State");
    }
}
