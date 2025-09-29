package Behavioural.State;

public class TrafficLight {
        private TrafficLightState state;

    public TrafficLight() {
        state = new RedState(); // initial state
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.change(this);
    }

    public void showState() {
        System.out.println("Current Light: " + state.getState());
    }
}

