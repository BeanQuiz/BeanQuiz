package za.co.bbd.cli.beanquiz.command;

import za.co.bbd.cli.beanquiz.Global;

public class BackCommand extends Command {
    public BackCommand() {
        super("b", "Back to menu");
    }


    @Override
    public Boolean execute() {
        Global.commands = Global.defaultCommands;
        return super.execute();
    }
}
