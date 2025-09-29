package Exp2.SatelliteSystem.command;
import Exp2.SatelliteSystem.core.SatelliteProxy;

public class CollectDataCommand implements ICommand {
    private final SatelliteProxy proxy;
    private final int amount;
    private boolean executed = false;

    public CollectDataCommand(SatelliteProxy proxy) {
        this(proxy, 10);
    }

    public CollectDataCommand(SatelliteProxy proxy, int amount) {
        this.proxy = proxy;
        this.amount = amount;
    }

    @Override
    public void execute() throws Exception {
        proxy.collectData(); 
        executed = true;
    }

    @Override
    public void undo() {
        if (executed) {
            proxy.reduceDataBy(amount);
            executed = false;
        } 
    }

    @Override
    public String getName() {
        return "collectData";
    }
}
