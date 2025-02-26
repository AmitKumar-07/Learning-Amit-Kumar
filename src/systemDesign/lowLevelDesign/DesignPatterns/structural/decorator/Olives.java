package systemDesign.lowLevelDesign.DesignPatterns.structural.decorator;

class Olives extends ToppingDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 1.00; // Additional cost for olives
    }
}
