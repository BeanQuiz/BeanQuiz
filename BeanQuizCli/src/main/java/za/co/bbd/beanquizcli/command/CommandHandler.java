package za.co.bbd.beanquizcli.command;

public class CommandHandler {
    private Command[] commands;

    public void setCommands(Command[] commands) {
        this.commands = commands;
    }

    public Command getCommand(String identifier) {
        for (Command command : commands) {
            if (identifier.equals(command.getIdentifier())) {
                return command;
            }
        }
        return new UnrecognisedCommand(identifier);
    }
}
