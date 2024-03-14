package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.cli.beanquiz.Global;

import java.util.ArrayList;
import java.util.List;

public class AnswerQuestionCommand extends Command {
    public AnswerQuestionCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public Boolean execute() {
        List<Command> commands = new ArrayList<>();
        String questionText = String.format("Question %s: %s", this.getIdentifier(), this.getDescription());
        String dashes = "-".repeat(questionText.length()+2);
        String fullText = String.format("%s\n%s", this.getDescription(), dashes);
        commands.add(new DisplayQuestionCommand("Question " + this.getIdentifier(), fullText));

    try {
            HttpResponse<JsonNode> response = Unirest
                    .get(Global.API_DOMAIN + "api/public/options")
                    .queryString("questionId", this.getIdentifier())
                    .asJson();

            Integer i = 0;

            for (Object o : response.getBody().getArray()) {
                i += 1;
                JSONObject obj = (JSONObject) o;
                commands.add(
                        new PickOptionCommand(
                                String.valueOf(i),
                                obj.getString("text"),
                                obj.getString("id"),
                                obj.getBoolean("isCorrect")
                        )
                );
            }

        } catch (Exception e) {
            Global.commands = Global.defaultCommands;
            System.out.println("An error occurred");
            return true;
        }

        commands.add(new BackCommand());
        Global.commands = commands;

        return super.execute();
    }
}
