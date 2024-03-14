package za.co.bbd.cli.beanquiz;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import za.co.bbd.cli.beanquiz.command.Command;

public class Output {
    public static void printWelcomeBanner() {
        System.out.println("""
                ***********************************************
                *                                             *
                *            Welcome to Bean Quiz!            *
                *                                             *
                ***********************************************"""
        );
    }

    public static void printCommands() {
        System.out.println();
        for (Command command : Global.commands) {
            if (!command.hidden()) {
                System.out.println(command.getIdentifier() + " - " + command.getDescription());
            }
        }
        System.out.println();
    }

    public static void printEnterCommand() {
        System.out.print("Please make a selection: ");
    }

    public static void printLoggedInUser() {
        if (!Global.user.isBlank()) {
            System.out.println("Logged In User: " + Global.user);
            return;
        }

        if (Global.accessToken.isBlank()) {
            return;
        }

        try {
            HttpResponse<JsonNode> response = Unirest
                    .get(Global.API_DOMAIN + "api/private/user")
                    .header("Authorization", Global.accessToken)
                    .asJson();

            if (response.getStatus() != 200) {
                return;
            }

            Global.user = response.getBody().getObject().getString("username");

            if (response.isSuccess()) {
                System.out.println("Logged In User: " + Global.user);
            }

        } catch (Exception e) {
        }
    }

}
