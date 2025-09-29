package Exp2.SatelliteSystem.controller;
import java.util.ArrayDeque;
import java.util.Deque;

import Exp2.SatelliteSystem.command.*;
import Exp2.SatelliteSystem.core.SatelliteProxy;
import Exp2.SatelliteSystem.exceptions.*;

public class SatelliteController {
    private static SatelliteController instance;

    private final SatelliteProxy proxy;
    private final Deque<ICommand> history;   
    private final Deque<ICommand> redoStack; 

    private SatelliteController(SatelliteProxy proxy) {
        this.proxy = proxy;
        this.history = new ArrayDeque<>();
        this.redoStack = new ArrayDeque<>();
    }

    public static SatelliteController getInstance(SatelliteProxy proxy) {
        if (instance == null) {
            instance = new SatelliteController(proxy);
        }
        return instance;
    }

    public void executeCommand(ICommand cmd) {
        try {
            cmd.execute();
            history.push(cmd);
            redoStack.clear();
        } catch (InvalidDirectionException | PanelActiveException ide) {
            System.out.println("[ERROR] " + ide.getMessage());
        } catch (Exception e) {
            System.out.println("[ERROR] Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("[WARN] Nothing to undo.");
            return;
        }
        ICommand last = history.pop();
        try {
            last.undo();
            redoStack.push(last);
            System.out.println("[INFO] Undid: " + last.getName());
        } catch (Exception e) {
            System.out.println("[ERROR] Undo failed: " + e.getMessage());
        }
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("[WARN] Nothing to redo.");
            return;
        }
        ICommand cmd = redoStack.pop();
        try {
            cmd.execute();
            history.push(cmd);
            System.out.println("[INFO] Redid: " + cmd.getName());
        } catch (Exception e) {
            System.out.println("[ERROR] Redo failed: " + e.getMessage());
        }
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("Command History: (empty)");
            return;
        }
        System.out.println("Command History (most recent first):");
        int idx = 1;
        for (ICommand c : history) {
            System.out.println(idx + ". " + c.getName());
            idx++;
        }
    }

    public ICommand parseCommand(String userInput) throws InvalidCommandException {
        if (userInput == null || userInput.isBlank()) {
            throw new InvalidCommandException("Empty command.");
        }
        String[] tokens = userInput.trim().split("\\s+");
        String cmd = tokens[0].toLowerCase();

        switch (cmd) {
            case "rotate":
                if (tokens.length < 2) throw new InvalidCommandException("Usage: rotate <North|South|East|West>");
                String dir = tokens[1];
                return new RotateCommand(proxy, capitalize(dir));
            case "activatepanels":
            case "activate":
            case "activatepanels()":
                return new ActivatePanelsCommand(proxy);
            case "deactivatepanels":
            case "deactivate":
            case "deactivatepanels()":
                return new DeactivatePanelsCommand(proxy);
            case "collectdata":
            case "collect":
            case "collectdata()":
                return new CollectDataCommand(proxy);
            case "status":
                return new ICommand() {
                    @Override
                    public void execute() {
                        System.out.println(proxy.status());
                    }
                    @Override
                    public void undo() {
                        // status has no undo
                    }
                    @Override
                    public String getName() {
                        return "status";
                    }
                };
            default:
                throw new InvalidCommandException("Unknown command: " + cmd);
        }
    }

    private String capitalize(String s) {
        if (s == null || s.isBlank()) return s;
        s = s.toLowerCase();
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
