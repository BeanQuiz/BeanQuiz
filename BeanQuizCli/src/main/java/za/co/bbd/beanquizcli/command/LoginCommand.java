package za.co.bbd.beanquizcli.command;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.beanquizcli.Global;

public class LoginCommand extends Command {

    public LoginCommand() {
        super("l", "Login");
    }

    @Override
    public Boolean execute() {
        System.out.println("Initiating Login...\n");

        HttpResponse<JsonNode> response = Unirest
                .post(Global.AUTH0_DOMAIN + "oauth/device/code")
                .body(new JsonNode("{\"client_id\":\"\"}"))
                .asJson();

        if (response.isSuccess()) {
            System.out.println("An error occurred...");
            return true;
        }

        JSONObject jsonObject = response.getBody().getObject();

        String deviceCode = jsonObject.getString("device_code");

        return super.execute();
    }
}
