package Behavioural.State;

public class GreenState implements TrafficLightState {
    public void change(TrafficLight light) {
        light.setState(new YellowState());
    }
    public String getState() {
        return "GREEN";
    }
}
