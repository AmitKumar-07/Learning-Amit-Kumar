package systemDesign.lowLevelDesign.DesignPatterns.behavioral.state;

public class OffState implements FanState {
    @Override
    public void turnOn(Fan fan) {
        System.out.println("Fan is now at Low Speed. Turning on.");
        fan.setState(new LowSpeedState());
    }

    @Override
    public void turnOff(Fan fan) {
        System.out.println("Fan is already Off.");
    }

    @Override
    public void increaseSpeed(Fan fan) {
        System.out.println("Cannot increase speed. Fan is Off.");
    }

    @Override
    public void decreaseSpeed(Fan fan) {
        System.out.println("Cannot decrease speed. Fan is Off.");
    }
}
