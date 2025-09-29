package Exp2.SatelliteSystem.observer;

public class Logger implements ISatelliteObserver {
    public void update(String stateMessage) {
        System.out.println(stateMessage);
    }
}