package za.co.bbd.cli.beanquiz;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import za.co.bbd.cli.beanquiz.command.Command;

public class Output {
    public static void printWelcomeBanner() {
        System.out.println("\u001B[32m"+
                """
                        dP   dP   dP          dP                                            dP                888888ba                                 .88888.            oo          dP\s
                        88   88   88          88                                            88                88    `8b                               d8'   `8b                       88\s
                        88  .8P  .8P .d8888b. 88 .d8888b. .d8888b. 88d8b.d8b. .d8888b.    d8888P .d8888b.    a88aaaa8P' .d8888b. .d8888b. 88d888b.    88     88  dP    dP dP d888888b 88\s
                        88  d8'  d8' 88ooood8 88 88'  `"" 88'  `88 88'`88'`88 88ooood8      88   88'  `88     88   `8b. 88ooood8 88'  `88 88'  `88    88  db 88  88    88 88    .d8P' dP\s
                        88.d8P8.d8P  88.  ... 88 88.  ... 88.  .88 88  88  88 88.  ...      88   88.  .88     88    .88 88.  ... 88.  .88 88    88    Y8.  Y88P  88.  .88 88  .Y8P      \s
                        8888' Y88'   `88888P' dP `88888P' `88888P' dP  dP  dP `88888P'      dP   `88888P'     88888888P `88888P' `88888P8 dP    dP     `8888PY8b `88888P' dP d888888P oo\s
                        ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo\s"""
                + "\u001B[0m"
        );
    }

    public static void printCommands() {
        System.out.println();
        for (Command command : Global.commands) {
            if (!command.hidden()) {
                System.out.print(command.getPrefix());
                System.out.println("\u001B[34m" + command.getIdentifier() + "\u001B[0m" + " - " + command.getDescription());
            }
        }
        System.out.println();
    }

    public static void printEnterCommand() {
        System.out.print("\u001B[32mBeanQuiz: \u001B[0m");
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
