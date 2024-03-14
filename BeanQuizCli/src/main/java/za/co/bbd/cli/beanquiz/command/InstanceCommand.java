package za.co.bbd.cli.beanquiz.command;

public class InstanceCommand extends Command {
    private final Command command;
    public InstanceCommand(String identifier, String description, Command command) {
        super(identifier, description);
        this.command = command;
    }

    @Override
    public Boolean execute() {
        return command.execute();
    }
}
