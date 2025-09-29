package Exp2.SatelliteSystem.core;
import Exp2.SatelliteSystem.exceptions.*;
import Exp2.SatelliteSystem.observer.ISatelliteObserver;
public class SatelliteProxy {
    private final Satellite satellite;

    public SatelliteProxy(Satellite satellite) {
        this.satellite = satellite;
    }

    public void rotate(String direction) throws InvalidDirectionException {
        satellite.rotate(direction);
    }

    public void activatePanels() {
        satellite.activatePanels();
    }

    public void deactivatePanels() {
        satellite.deactivatePanels();
    }

    public void collectData() throws PanelActiveException  {
        satellite.collectData();
    }

    public void reduceDataBy(int amount) {
        satellite.reduceDataBy(amount);
    }

    public String status() {
        return satellite.status();
    }

    public void addObserver(ISatelliteObserver obs) {
        satellite.addObserver(obs);
    }
}
