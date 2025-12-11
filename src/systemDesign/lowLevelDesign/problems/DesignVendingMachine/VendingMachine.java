package systemDesign.lowLevelDesign.problems.DesignVendingMachine;

import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.State;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.VendingStates.impl.IdleState;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private State state;
    private final Inventory inventory;
    private final List<Coin> coinList;
    private int selectedCode;

    public VendingMachine() {
        this.state = new IdleState();
        this.inventory = new Inventory(4);
        this.coinList = new ArrayList<>();
    }

    public void insertCoin(Coin coin) throws Exception {
        state.insertCoin(this, coin);
    }

    public void setState(State state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getSelectedCode() {
        return selectedCode;
    }

    public void setSelectedCode(int selectedCode) {
        this.selectedCode = selectedCode;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void addCoin(Coin coin) {
        this.coinList.add(coin);
    }

    public int getTotalMoney() {
        return coinList.stream().mapToInt(coin-> coin.getValue()).sum();
    }

    public void selectItem(int code) throws Exception {
        state.selectItem(this, code);
    }

    public void dispense() throws Exception {
        state.dispense(this);
    }
}
