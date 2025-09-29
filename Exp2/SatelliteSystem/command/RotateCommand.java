package Exp2.SatelliteSystem.command;
import Exp2.SatelliteSystem.core.SatelliteProxy;
public class RotateCommand implements ICommand {
    private final SatelliteProxy proxy;
    private final String newDirection;
    private String previousDirection;
    public RotateCommand(SatelliteProxy proxy, String newDirection) {
        this.proxy = proxy;
        this.newDirection = newDirection;
    }

    @Override
    public void execute() throws Exception {
       
        String status = proxy.status(); 
        String prev = parseOrientation(status);
        previousDirection = prev;
        proxy.rotate(newDirection);
    }

    @Override
    public void undo() throws Exception {
        if (previousDirection != null) {
            proxy.rotate(previousDirection);
        }
    }

    @Override
    public String getName() {
        return "rotate " + newDirection;
    }

    private String parseOrientation(String statusString) {
        try {
            String[] parts = statusString.split("\\|");
            for (String p : parts) {
                p = p.trim();
                if (p.startsWith("Orientation:")) {
                    return p.substring("Orientation:".length()).trim();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "North";
    }
}
