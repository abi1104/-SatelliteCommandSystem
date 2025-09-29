package Behavioural.State;

public interface TrafficLightState {
    void change(TrafficLight light);
    String getState();

}
