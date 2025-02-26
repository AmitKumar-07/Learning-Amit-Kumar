package systemDesign.lowLevelDesign.DesignPatterns.behavioral.state;

public class Fan {
    private FanState currentState;

    public Fan() {
        this.currentState = new OffState(); // Initial state
    }

    public void setState(FanState state) {
        this.currentState = state;
    }

    public void turnOn() {
        currentState.turnOn(this);
    }

    public void turnOff() {
        currentState.turnOff(this);
    }

    public void increaseSpeed() {
        currentState.increaseSpeed(this);
    }

    public void decreaseSpeed() {
        currentState.decreaseSpeed(this);
    }
}