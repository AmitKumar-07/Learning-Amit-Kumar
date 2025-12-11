package systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates;

import systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums.Coin;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingMachine;

public interface State {

    void insertCoin(VendingMachine vm, Coin coin) throws Exception;

    void selectItem(VendingMachine vm, int code) throws Exception;

    void dispense(VendingMachine vm) throws Exception;
}
