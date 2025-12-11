package systemDesign.lowLevelDesign.problems.DesignVendingMachine.enums;

public enum Coin {

    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY_FIVE(25);

    public final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
