package systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.impl;

import systemDesign.lowLevelDesign.problems.DesignVendingMachine.Item;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingMachine;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.State;

public class SelectionState implements State {

    @Override
    public void insertCoin(VendingMachine vm, systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums.Coin coin) {
        System.out.println("Item already selected. Cannot insert more coins now.");
    }

    @Override
    public void selectItem(VendingMachine vm, int code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense(VendingMachine vm) throws Exception {

        int code = vm.getSelectedCode();

        // Try getting item
        Item item = vm.getInventory().getItem(code);  // may throw exception

        int price = item.getPrice();
        int total = vm.getTotalMoney();

        if (total < price) {
            System.out.println("Insufficient money! Insert more coins.");
            vm.setState(new HasMoneyState());
            return;
        }

        System.out.println("Money sufficient. Proceeding to dispense item.");

        // Move to next state and immediately dispense
        vm.setState(new DispenseState(item));
        vm.dispense();  // Automatically trigger dispense in the new state
    }

}
