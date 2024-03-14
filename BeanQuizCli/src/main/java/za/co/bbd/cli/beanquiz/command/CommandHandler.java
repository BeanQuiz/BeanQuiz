package za.co.bbd.cli.beanquiz.command;

import java.util.List;

public class CommandHandler {
    private List<Command> commands;

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public Command getCommand(String identifier) {
        for (Command command : commands) {
            if (command.enabled() && identifier.equalsIgnoreCase(command.getIdentifier())) {
                return command;
            }
        }
        return new UnrecognisedCommand(identifier);
    }
}
