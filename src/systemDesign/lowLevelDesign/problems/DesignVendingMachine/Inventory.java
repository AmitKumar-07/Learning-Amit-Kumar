package systemDesign.lowLevelDesign.problems.DesignVendingMachine;

import java.util.List;

public class Inventory {

    ItemShelf[] inventory;

    Inventory(int size) {
        inventory = new ItemShelf[size];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new ItemShelf(startCode);
            startCode++;
        }
    }

    // Add multiple items to a shelf
    public void addItem(List<Item> items, int codeNumber) throws Exception {
        ItemShelf shelf = findShelf(codeNumber);

        if (shelf == null) {
            throw new Exception("Invalid Code Entered!!");
        }
        shelf.setItems(items);
    }

    // Dispense one item
    public Item getItem(int codeNumber) throws Exception {
        ItemShelf shelf = findShelf(codeNumber);

        if (shelf == null)
            throw new Exception("Invalid Code Entered!!");

        if (shelf.isSoldOut()) {
            throw new Exception("Item sold out, Please try something else!!");
        }

        List<Item> items = shelf.getItems();

        if (items == null || items.isEmpty()) {
            shelf.setSoldOut(true);
            throw new Exception("Item sold out, Please try something else!!");
        }

        // remove 1 item from list
        Item item = items.remove(0);

        if (items.isEmpty()) {
            shelf.setSoldOut(true);
        }

        return item;
    }

    public void updateSoldOutItem(int codeNumber) {
        ItemShelf shelf = findShelf(codeNumber);
        if (shelf != null) {
            shelf.setSoldOut(true);
        }
    }

    private ItemShelf findShelf(int codeNumber) {
        for (ItemShelf shelf : inventory) {
            if (shelf.getCode() == codeNumber)
                return shelf;
        }
        return null;
    }
}
