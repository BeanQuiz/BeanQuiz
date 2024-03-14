package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.cli.beanquiz.Global;

import java.util.concurrent.TimeUnit;

public class LoginCommand extends Command {

    public LoginCommand() {
        super("l", "Login");
    }

    @Override
    public Boolean execute() {
        System.out.println("Initiating Login...\n");

        HttpResponse<JsonNode> response = Unirest
                .post(Global.AUTH0_DOMAIN + "oauth/device/code")
                .header("content-type", "application/x-www-form-urlencoded")
                .field("client_id", Global.AUTH0_CLIENT_ID)
                .field("scope", "openid profile email")
                .field("audience", Global.AUTH0_AUDIENCE)
                .asJson();

        if (!response.isSuccess()) {
            System.out.println("An error occurred...");
            return true;
        }

        JSONObject jsonObject = response.getBody().getObject();

        String deviceCode = jsonObject.getString("device_code");
        String userCode = jsonObject.getString("user_code");
        String verificationUriComplete = jsonObject.getString("verification_uri_complete");

        System.out.println("User Code: " + userCode);
        System.out.println("Please open link in browser to login: " + verificationUriComplete + "");

        System.out.print("Awaiting Login");

        while (true) {
            try {
                System.out.print(".");
                TimeUnit.SECONDS.sleep(2);
                response = Unirest
                        .post(Global.AUTH0_DOMAIN + "oauth/token")
                        .header("content-type", "application/x-www-form-urlencoded")
                        .field("client_id", Global.AUTH0_CLIENT_ID)
                        .field("device_code", deviceCode)
                        .field("grant_type", "urn:ietf:params:oauth:grant-type:device_code")
                        .asJson();
                if (response.getStatus() == 200) {
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("An error occurred...");
                return true;
            }
        }

        Global.accessToken = "Bearer " + response.getBody().getObject().getString("access_token");

        try {
            response = Unirest.post(Global.API_DOMAIN + "api/private/user")
                    .header("Authorization", Global.accessToken)
                    .asJson();

            if (response.getStatus() != 201) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            System.out.println("An error occurred...");
            return true;
        }

        System.out.println("\nLogin Successful!\n");

        return super.execute();
    }
}
