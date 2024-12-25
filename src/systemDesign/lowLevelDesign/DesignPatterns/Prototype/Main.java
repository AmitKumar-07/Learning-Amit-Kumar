package systemDesign.lowLevelDesign.DesignPatterns.Prototype;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Shape("Circle", "Red");
        System.out.println("Original Object: " + circle);

        // Clone the object
        Shape clonedCircle = circle.clone();
        System.out.println("Cloned Object: " + clonedCircle);

        // Modify the cloned object
        clonedCircle.setColor("Blue");
        System.out.println("After Modification:");
        System.out.println("Original Object: " + circle);
        System.out.println("Cloned Object: " + clonedCircle);
    }
}