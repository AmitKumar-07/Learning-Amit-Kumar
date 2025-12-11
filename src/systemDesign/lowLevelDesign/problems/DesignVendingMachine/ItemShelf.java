package systemDesign.lowLevelDesign.problems.DesignVendingMachine;

import java.util.ArrayList;
import java.util.List;

public class ItemShelf {

    int code;
    private List<Item> items;
    boolean soldOut;

    public ItemShelf(int code){
        this.code = code;
        this.items = new ArrayList<>();
        this.soldOut = true;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        if(items != null && !items.isEmpty()) {
            this.soldOut = false;
        }
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }
}
