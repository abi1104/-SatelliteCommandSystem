package Exp2.SatelliteSystem.command;
import Exp2.SatelliteSystem.core.SatelliteProxy;
public class DeactivatePanelsCommand implements ICommand {
    private final SatelliteProxy proxy;
    private boolean wasActiveBefore = false;

    public DeactivatePanelsCommand(SatelliteProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void execute() {
        String status = proxy.status();
        wasActiveBefore = parsePanels(status);
        proxy.deactivatePanels();
    }

    @Override
    public void undo() {
        if (wasActiveBefore) {
            proxy.activatePanels();
        } else {
            proxy.deactivatePanels(); 
        }
    }

    @Override
    public String getName() {
        return "deactivatePanels";
    }

    private boolean parsePanels(String statusString) {
        try {
            String[] parts = statusString.split("\\|");
            for (String p : parts) {
                p = p.trim();
                if (p.startsWith("Panels:")) {
                    String val = p.substring("Panels:".length()).trim();
                    return val.equalsIgnoreCase("Active");
                }
            }
        } catch (Exception e) {}
        return false;
    }
}