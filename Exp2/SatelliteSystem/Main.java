package Exp2.SatelliteSystem;
import java.util.Scanner;

import Exp2.SatelliteSystem.command.ICommand;
import Exp2.SatelliteSystem.controller.SatelliteController;
import Exp2.SatelliteSystem.core.Satellite;
import Exp2.SatelliteSystem.core.SatelliteProxy;
import Exp2.SatelliteSystem.exceptions.InvalidCommandException;
import Exp2.SatelliteSystem.observer.Logger;

public class Main {
    public static void main(String[] args) {
        Satellite satellite = new Satellite();
        SatelliteProxy proxy = new SatelliteProxy(satellite);

        Logger logger = new Logger();
        proxy.addObserver(logger);

      
        SatelliteController controller = SatelliteController.getInstance(proxy);

        System.out.println("=== Satellite Command System ===");
        System.out.println("Available commands: rotate <North|South|East|West>, activatePanels, deactivatePanels, collectData, status, undo, redo, history, exit");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Exiting. Bye!");
                break;
            } else if (line.equalsIgnoreCase("undo")) {
                controller.undo();
            } else if (line.equalsIgnoreCase("redo")) {
                controller.redo();
            } else if (line.equalsIgnoreCase("history")) {
                controller.showHistory();
            } else {
                try {
                    ICommand command = controller.parseCommand(line);
                    if (command.getName().equals("status")) {
                        command.execute();
                    } else {
                        controller.executeCommand(command);
                    }
                } catch (InvalidCommandException ice) {
                    System.out.println("[ERROR] " + ice.getMessage());
                } catch (Exception e) {
                    System.out.println("[ERROR] Unexpected: " + e.getMessage());
                }
            }
        }

        sc.close();
    }
}
