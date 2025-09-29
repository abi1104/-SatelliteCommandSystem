package Behavioural.State;

public class RedState implements TrafficLightState {
    public void change(TrafficLight light) {
        light.setState(new GreenState());
    }
    public String getState() {
        return "RED";
    }
}
