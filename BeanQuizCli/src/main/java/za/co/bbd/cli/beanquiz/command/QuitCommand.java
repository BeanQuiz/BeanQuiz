package za.co.bbd.cli.beanquiz.command;

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
