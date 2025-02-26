package systemDesign.lowLevelDesign.DesignPatterns.behavioral.state;

public class LowSpeedState implements FanState {
    @Override
    public void turnOn(Fan fan) {
        System.out.println("Fan is already On at Low Speed.");
    }

    @Override
    public void turnOff(Fan fan) {
        System.out.println("Turning fan off.");
        fan.setState(new OffState());
    }

    @Override
    public void increaseSpeed(Fan fan) {
        System.out.println("Fan is now at High Speed.");
        fan.setState(new HighSpeedState());
    }

    @Override
    public void decreaseSpeed(Fan fan) {
        System.out.println("Turning fan off.");
        fan.setState(new OffState());
    }
}
