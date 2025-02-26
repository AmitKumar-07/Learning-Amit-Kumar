package systemDesign.lowLevelDesign.DesignPatterns.behavioral.state;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();

        fan.turnOff();
        fan.turnOn();   // Fan is now at Low Speed
        fan.decreaseSpeed();   // Fan is now at High Speed
        fan.increaseSpeed();   // Fan is already at High Speed
        fan.turnOn();  // Turning fan off
        fan.turnOff();  // Fan is already Off
    }
}
