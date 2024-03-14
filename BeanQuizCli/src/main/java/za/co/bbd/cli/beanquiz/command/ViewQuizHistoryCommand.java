package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.cli.beanquiz.Global;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ViewQuizHistoryCommand extends Command{
    public ViewQuizHistoryCommand() {
        super("H", "View Quiz History");
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
        HttpResponse<JsonNode> attemptsResponse = Unirest
                .get(Global.API_DOMAIN + "api/private/user-quiz-attempts")
                .header("Authorization", Global.accessToken)
                .asJson();

        if (!attemptsResponse.isSuccess()) {
            System.out.println("An error occurred...");
            return true;
        }

        System.out.format("\u001B[34m%-15s%-15s%-15s%n", "QuizID", "Duration", "Score\u001B[0m");

        for (Object previousQuizzes : attemptsResponse.getBody().getArray()) {
            JSONObject obj = (JSONObject) previousQuizzes;
            String id = obj.getString("id");
            String userId = obj.getString("userId");
            String quizId = obj.getString("quizId");
            String startTimestamp = obj.getString("startTimestamp");
            String endTimestamp = obj.getString("endTimestamp");
            String score = obj.getString("score");

            HttpResponse<JsonNode> quizDetailsResponse = Unirest
                    .get(Global.API_DOMAIN + "api/public/quiz/" + quizId)
                    .asJson();

            if (!quizDetailsResponse.isSuccess()) {
                System.out.println("An error occurred...");
                return true;
            }

            JSONObject objQuizDetails = (JSONObject) quizDetailsResponse.getBody().getObject();
            String quizName = objQuizDetails.getString("title");
            String totalQuestions = objQuizDetails.getString("totalQuestions");


            System.out.format("%-15s%-15s%-15s%n", quizName, getDurationFromTimestamps(startTimestamp, endTimestamp), score + "/" + totalQuestions);
        }

        List<Command> commands = new ArrayList<>();
        commands.add(new BackCommand());
        Global.commands = commands;

        return super.execute();
    }

    private static String getDurationFromTimestamps(String startTimestamp, String endTimestamp){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        OffsetDateTime startTime = OffsetDateTime.parse(startTimestamp, formatter);
        OffsetDateTime endTime = OffsetDateTime.parse(endTimestamp, formatter);

        Duration duration = Duration.between(startTime, endTime);

        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        return String.format("%02d:%02d", minutes, seconds);
    }
}
