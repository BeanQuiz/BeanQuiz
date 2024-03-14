package za.co.bbd.beanquizcli.command;

public class QuitCommand extends Command {
    public QuitCommand() {
        super("q", "Quit");
    }

    @Override
    public Boolean execute() {
        System.out.println("Goodbye!!!");
        return false;
    }
}
