package za.co.bbd.beanquizcli.command;

public class UnrecognisedCommand extends Command {
    public UnrecognisedCommand(String identifier) {
        super("?", "\"" + identifier + "\" is not a valid selection.\n");
    }

    @Override
    public Boolean execute() {
        System.out.println(this.getDescription());
        return super.execute();
    }
}
