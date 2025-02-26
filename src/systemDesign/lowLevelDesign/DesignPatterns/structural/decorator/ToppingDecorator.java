package systemDesign.lowLevelDesign.DesignPatterns.structural.decorator;

abstract class ToppingDecorator implements Pizza {

    //Exact Reason: To Prevent Instantiation of an Incomplete Object
    //The ToppingDecorator by itself does not provide any additional functionality to the Pizza.
    //It is meant to serve as a base for specific decorators like Cheese or Olives.
    //Making it abstract ensures that no one can accidentally instantiate the ToppingDecorator class directly.
    protected Pizza tempPizza;

    public ToppingDecorator(Pizza pizza) {
        this.tempPizza = pizza;
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription();
    }

    @Override
    public double getCost() {
        return tempPizza.getCost();
    }
}

