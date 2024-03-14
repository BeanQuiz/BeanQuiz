package za.co.bbd.beanquizcli.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.beanquizcli.Global;
import com.fasterxml.jackson.databind.ObjectMapper;
import za.co.bbd.beanquizcli.dto.QuizDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListQuizCommand extends Command {
    public ListQuizCommand() {
        super("t", "Take Quiz");
    }

    @Override
    public Boolean execute() {
        HttpResponse<JsonNode> response = Unirest
                .get(Global.API_DOMAIN + "api/public/quizzes")
                .asJson();

        if (!response.isSuccess()) {
            System.out.println("An error occurred...");
            System.out.println(response.toString());
            return true;
        }

        String jsonArray = response.getBody().toString();


        QuizDTO[] quizDTOs = new QuizDTO[0];
        try {
            quizDTOs = Global.objectMapper.readValue(jsonArray, QuizDTO[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        List<TakeQuizCommand> takeQuizCommandList = Arrays.stream(quizDTOs)
                .map(quizDTO -> {
                    String description = quizDTO.getTitle() + ": " + quizDTO.getDescription() + " (" + quizDTO.getTotalQuestions() + " Questions)";
                    return new TakeQuizCommand(String.valueOf(quizDTO.getId()), description);
                })
                .toList();

        Global.commands = takeQuizCommandList.toArray(new Command[0]);

        return super.execute();
    }
}
