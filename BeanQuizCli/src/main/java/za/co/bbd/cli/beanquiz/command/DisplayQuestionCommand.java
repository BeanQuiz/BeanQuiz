package za.co.bbd.cli.beanquiz.command;

public class DisplayQuestionCommand extends Command {

    public DisplayQuestionCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public Boolean enabled() {
        return false;
    }
}
