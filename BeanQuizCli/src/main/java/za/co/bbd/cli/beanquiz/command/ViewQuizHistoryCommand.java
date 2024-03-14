package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.cli.beanquiz.Global;

import java.time.Duration;
import java.time.LocalDateTime;
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
        HttpResponse<JsonNode> response = Unirest
                .get(Global.API_DOMAIN + "user-quiz-attempts")
                .asJson();

        if (!response.isSuccess()) {
            System.out.println("An error occurred...");
            return true;
        }

        System.out.format("%-15s%-15s%-15s%\n", "QuizID", "Duration", "Score");

        for (Object previousQuizzes : response.getBody().getArray()) {
            JSONObject obj = (JSONObject) previousQuizzes;
            String id = obj.getString("id");
            String userId = obj.getString("userId");
            String quizId = obj.getString("quizId");
            String startTimestamp = obj.getString("startTimestamp");
            String endTimestamp = obj.getString("endTimestamp");
            String score = obj.getString("score");

            System.out.format("%-15d%-15s%-15s%\n", id, getDurationFromTimestamps(startTimestamp, endTimestamp), score);
        }

        List<Command> commands = new ArrayList<>();
        commands.add(new BackCommand());
        Global.commands = commands;

        return super.execute();
    }

    private static String getDurationFromTimestamps(String startTimestamp, String endTimestamp){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSX");

        LocalDateTime startTime = LocalDateTime.parse(startTimestamp, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimestamp, formatter);

        Duration duration = Duration.between(startTime, endTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        return hours + ":" + minutes + ":" + seconds;
    }
}
