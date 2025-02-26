package systemDesign.lowLevelDesign.DesignPatterns.behavioral.state;

public class HighSpeedState implements FanState {

    @Override
    public void turnOn(Fan fan) {
        System.out.println("Fan is already On at High Speed.");
    }

    @Override
    public void turnOff(Fan fan) {
        System.out.println("Turning fan off.");
        fan.setState(new OffState());
    }

    @Override
    public void increaseSpeed(Fan fan) {
        System.out.println("Fan is already at High Speed.");
    }

    @Override
    public void decreaseSpeed(Fan fan) {
        System.out.println("Fan is now at Low Speed.");
        fan.setState(new LowSpeedState());
    }
}
