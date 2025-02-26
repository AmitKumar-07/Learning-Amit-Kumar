package systemDesign.lowLevelDesign.DesignPatterns.structural.decorator;

public class ExtraCheese extends ToppingDecorator{

    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + 2.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+", extra cheese";
    }
}
