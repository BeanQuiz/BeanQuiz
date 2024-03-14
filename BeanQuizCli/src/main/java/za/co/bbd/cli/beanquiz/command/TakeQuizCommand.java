package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.cli.beanquiz.Global;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TakeQuizCommand extends Command {
    private final Integer totalQuestions;

    public TakeQuizCommand(String quizId, Integer totalQuestions) {
        super(quizId, "");
        this.totalQuestions = totalQuestions;
    }

    @Override
    public Boolean execute() {
        Global.userQuestionResponses = new ArrayList<>();
        Global.quizId = Integer.parseInt(this.getIdentifier());
        Global.score = 0;
        Global.totalQuestions = this.totalQuestions;
        Global.startTimestamp = new Date();

        try {
            HttpResponse<JsonNode> response = Unirest
                    .get(Global.API_DOMAIN + "api/public/questions")
                    .queryString("quizId", this.getIdentifier())
                    .asJson();

            List<JSONObject> questions = new ArrayList<>();

            for (Object o : response.getBody().getArray()) {
                questions.add((JSONObject) o);
            }

            Global.questions = questions;

        } catch (Exception e) {
            Global.commands = Global.defaultCommands;
            System.out.println("An error occurred");
            return true;
        }

        JSONObject question = Global.questions.removeFirst();

        return new AnswerQuestionCommand(question.getString("id"), question.getString("text")).execute();
    }
}
