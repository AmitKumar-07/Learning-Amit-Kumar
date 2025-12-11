package systemDesign.lowLevelDesign.problems.DesignVendingMachine;

import systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums.Coin;
import systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums.ItemType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            VendingMachine vendingMachine = new VendingMachine();

            System.out.println("----- Filling Inventory -----");
            fillUpInventory(vendingMachine);

            displayInventory(vendingMachine);

            System.out.println("\n----- Inserting Coins -----");
            vendingMachine.insertCoin(Coin.TEN);
            vendingMachine.insertCoin(Coin.TWENTY_FIVE);

            System.out.println("\n----- Selecting Product -----");
            vendingMachine.selectItem(102);

            System.out.println("\n----- Dispensing -----");
            vendingMachine.dispense();      // Dispense item and return change (if any)

            System.out.println("\n----- Final Inventory -----");
            displayInventory(vendingMachine);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {

        ItemShelf[] shelves = vendingMachine.getInventory().getInventory();

        for (int i = 0; i < shelves.length; i++) {

            List<Item> items = new ArrayList<>();

            Item item = new Item();

            if (i < 1) {
                item.setType(ItemType.COKE);
                item.setPrice(12);
            } else if (i < 2) {
                item.setType(ItemType.PEPSI);
                item.setPrice(9);
            } else if (i < 3) {
                item.setType(ItemType.JUICE);
                item.setPrice(13);
            } else {
                item.setType(ItemType.SODA);
                item.setPrice(7);
            }

            // Put 3 items in each shelf
            items.add(item);
            items.add(item);
            items.add(item);

            shelves[i].setItems(items);
            shelves[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {

        ItemShelf[] shelves = vendingMachine.getInventory().getInventory();
        System.out.println("\n----- Inventory State -----");
        for (ItemShelf shelf : shelves) {

            boolean available = !shelf.isSoldOut();
            List<Item> items = shelf.getItems();
            Item item = (items != null && !items.isEmpty()) ? items.get(0) : null;

            System.out.println(
                    "Code: " + shelf.getCode() + ", Item: " + (item != null ? item.getType() : "EMPTY") +
                            ", Price: " + (item != null ? item.getPrice() : "-") + ", Available: " + available +
                            ", Quantity: " + (item != null ? items.size() : 0)
            );
        }
    }
}
