package za.co.bbd.beanquizcli.command;

public class PickOptionCommand extends Command{
    public PickOptionCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public Boolean execute() {

        return !super.execute();
    }
}
