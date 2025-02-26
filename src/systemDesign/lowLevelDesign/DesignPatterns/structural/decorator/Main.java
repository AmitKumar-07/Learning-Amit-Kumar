package systemDesign.lowLevelDesign.DesignPatterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        // Start with a plain pizza
        Pizza pizza = new PlainPizza();
        pizza = new Cheese(pizza);

        // Add olives topping
        pizza = new Olives(pizza);
        pizza=new Cheese(pizza);
        pizza=new ExtraCheese(pizza);

        // Display the final pizza description and cost
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());
    }
}
