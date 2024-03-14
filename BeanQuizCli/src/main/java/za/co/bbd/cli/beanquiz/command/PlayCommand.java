package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.cli.beanquiz.Global;

import java.util.ArrayList;
import java.util.List;

public class PlayCommand extends Command {
    public PlayCommand() {
        super("T", "Take Quiz");
    }

    @Override
    public Boolean execute() {
        HttpResponse<JsonNode> response = Unirest
                .get(Global.API_DOMAIN + "api/public/quizzes")
                .asJson();

        if (!response.isSuccess()) {
            System.out.println("An error occurred...");
            return true;
        }

        List<Command> commands = new ArrayList<>();

        for (Object quizDetails : response.getBody().getArray()) {
            JSONObject obj = (JSONObject) quizDetails;
            String quizId = obj.getString("id");
            commands.add(
                    new InstanceCommand(
                            quizId,
                            obj.getString("title")
                            + " > " + obj.getString("description")
                            + " > Total Questions: " + obj.getString("totalQuestions"),
                            new TakeQuizCommand(quizId, obj.getInt("totalQuestions"))
                    )
            );
        }

        commands.add(new BackCommand());

        Global.commands = commands;

        JSONObject jsonObject = response.getBody().getObject();


        return super.execute();
    }
}
