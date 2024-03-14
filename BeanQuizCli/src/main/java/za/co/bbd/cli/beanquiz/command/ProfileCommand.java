package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.HttpStatus;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import za.co.bbd.cli.beanquiz.Global;

import java.util.Arrays;
import java.util.List;

public class ProfileCommand extends Command{
    public ProfileCommand() {
        super("P", "Profile");
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
        Global.commands = Arrays.asList(
                new UpdateUsernameCommand(),
                new ViewQuizHistoryCommand(),
                new BackCommand()
        );

        return super.execute();
    }
}
