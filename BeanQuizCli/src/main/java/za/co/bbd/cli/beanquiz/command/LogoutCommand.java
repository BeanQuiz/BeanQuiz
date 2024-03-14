package za.co.bbd.cli.beanquiz.command;

import za.co.bbd.cli.beanquiz.Global;

public class LogoutCommand extends Command {
    public LogoutCommand() {
        super("X", "Logout");
    }

    @Override
    public Boolean hidden() {
        return Global.user.isBlank();
    }

    @Override
    public Boolean enabled() {
        return !Global.user.isBlank();
    }

    @Override
    public Boolean execute() {
        Global.user = "";
        Global.accessToken = "";
        System.out.println("\nSuccessfully Logged Out!");
        return super.execute();
    }
}
