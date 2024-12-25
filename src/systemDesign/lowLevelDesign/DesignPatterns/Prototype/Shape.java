package systemDesign.lowLevelDesign.DesignPatterns.Prototype;

public class Shape implements Prototype {
    private String type;
    private String color;

    public Shape(String type, String color) {
        this.type = type;
        this.color = color;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Shape clone() {
        // Create a new object with the same values
        return new Shape(this.type, this.color);
    }

    @Override
    public String toString() {
        return "Shape [Type=" + type + ", Color=" + color + "]";
    }
}
