package Exp2.SatelliteSystem.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Exp2.SatelliteSystem.exceptions.*;
import Exp2.SatelliteSystem.observer.ISatelliteObserver;


public class Satellite {
    private String orientation = "North";
    private boolean panelsActive = false;
    private int dataCollected = 0;

    private final List<String> validDirections = Arrays.asList("North", "South", "East", "West");
    private final List<ISatelliteObserver> observers = new ArrayList<>();

    public void addObserver(ISatelliteObserver obs) {
        if (obs != null && !observers.contains(obs)) {
            observers.add(obs);
        }
    }

    public void removeObserver(ISatelliteObserver obs) {
        observers.remove(obs);
    }

    private void notifyObservers(String msg) {
        for (ISatelliteObserver o : observers) {
            o.update(msg);
        }
    }

    public void rotate(String newOrientation) throws InvalidDirectionException {
    if (newOrientation == null || !validDirections.contains(newOrientation)) {
        throw new InvalidDirectionException("Invalid direction: " + newOrientation + ". Allowed: " + validDirections);
    }
    if (this.orientation.equalsIgnoreCase(newOrientation)) {
        notifyObservers("[WARN] Already facing " + newOrientation + ".");
        return;
    }
    this.orientation = newOrientation;
    notifyObservers("[INFO] Rotated to " + newOrientation);
}


    public void activatePanels() {
        if (panelsActive) {
            notifyObservers("[WARN] Panels already active.");
        } else {
            panelsActive = true;
            notifyObservers("[INFO] Panels activated.");
        }
    }

    public void deactivatePanels() {
        if (!panelsActive) {
            notifyObservers("[WARN] Panels already inactive.");
        } else {
            panelsActive = false;
            notifyObservers("[INFO] Panels deactivated.");
        }
    }

    public void collectData() throws PanelActiveException {
        if (!panelsActive) {
            throw new PanelActiveException("Cannot collect data: panels are inactive.");
        }
        this.dataCollected += 10; 
        notifyObservers("[INFO] Data collected. Total = " + dataCollected + " units.");
    }

    public void reduceDataBy(int amount) {
        this.dataCollected = Math.max(0, this.dataCollected - amount);
        notifyObservers("[UNDO] Data reduced. Total = " + dataCollected + " units.");
    }

    public String getOrientation() {
        return orientation;
    }

    public boolean isPanelsActive() {
        return panelsActive;
    }

    public int getDataCollected() {
        return dataCollected;
    }

    public String status() {
        return "STATUS -> Orientation: " + orientation +
               " | Panels: " + (panelsActive ? "Active" : "Inactive") +
               " | Data: " + dataCollected + " units";
    }
}
