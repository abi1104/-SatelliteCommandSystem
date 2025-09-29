package Exp2.SatelliteSystem.command;

public interface ICommand {
    void execute() throws Exception;
    void undo() throws Exception;
    String getName();

}
