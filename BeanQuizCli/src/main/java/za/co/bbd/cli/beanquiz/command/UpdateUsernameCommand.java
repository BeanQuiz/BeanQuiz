package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.HttpStatus;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONString;
import za.co.bbd.cli.beanquiz.Global;

import java.util.Arrays;
import java.util.Date;

public class UpdateUsernameCommand extends Command{
    public UpdateUsernameCommand() {
        super("U", "Update Username");
    }

    @Override
    public Boolean execute() {
        System.out.print("Please enter a new username\n> ");
        String newUsername = Global.scanner.nextLine().trim();
        if (!newUsername.isBlank())
        {
            HttpResponse<JsonNode> response = Unirest
                    .post(Global.API_DOMAIN + "api/private/user/username")
                    .header("content-type", "application/json")
                    .header("Authorization", Global.accessToken)
                    .body("{\"username\":\"" + newUsername +"\"}")
                    .asJson();

            if (HttpStatus.CREATED == response.getStatus()){
                System.out.println("Username changed successfully!");
                Global.user = newUsername;
            } else {
                System.out.println("A problem was encountered :( Username remains unchanged.");
            }
        }
        Global.commands = Global.defaultCommands;
        return super.execute();
    }
}
