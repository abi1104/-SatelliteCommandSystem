package Behavioural.State;

public class YellowState implements TrafficLightState {
    public void change(TrafficLight light) {
        light.setState(new RedState());
    }
    public String getState() {
        return "YELLOW";
    }
}
