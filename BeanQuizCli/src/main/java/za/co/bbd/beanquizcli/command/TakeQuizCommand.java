package za.co.bbd.beanquizcli.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import za.co.bbd.beanquizcli.Global;
import za.co.bbd.beanquizcli.Output;
import za.co.bbd.beanquizcli.dto.OptionDTO;
import za.co.bbd.beanquizcli.dto.QuestionDTO;
import za.co.bbd.beanquizcli.dto.QuizDTO;

import java.util.Arrays;
import java.util.List;

public class TakeQuizCommand extends Command {
    public TakeQuizCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public Boolean execute() {
        HttpResponse<JsonNode> response = Unirest
                .get(Global.API_DOMAIN + "api/public/questions")
                .queryString("quizId", getIdentifier())
                .asJson();

        String jsonArray = response.getBody().toString();

        QuestionDTO[] questionDTOs = new QuestionDTO[0];
        try {
            questionDTOs = Global.objectMapper.readValue(jsonArray, QuestionDTO[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        for (QuestionDTO questionDTO : questionDTOs) {

            HttpResponse<JsonNode> responseOptions = Unirest
                    .get(Global.API_DOMAIN + "api/public/options")
                    .queryString("questionId", questionDTO.getId())
                    .asJson();

            String jsonArrayOptions = responseOptions.getBody().toString();

            OptionDTO[] optionDTOS = new OptionDTO[0];
            try {
                optionDTOS = Global.objectMapper.readValue(jsonArrayOptions, OptionDTO[].class);
            } catch (JsonProcessingException e){
                throw new RuntimeException(e);
            }

            int outputID = 1;
            for (OptionDTO optionDTO : optionDTOS){
                optionDTO.setOutputID(outputID);
                outputID++;
            }

            List<PickOptionCommand> pickOptionCommandList = Arrays.stream(optionDTOS)
                    .map(optionDTO -> {
                        return new PickOptionCommand(String.valueOf(optionDTO.getOutputID()), optionDTO.getText());
                    })
                    .toList();

            Global.commands = pickOptionCommandList.toArray(new Command[0]);

            Boolean shouldContinue = true;
            CommandHandler commandHandler = new CommandHandler();
            while (shouldContinue) {

                System.out.println("Question " + questionDTO.getId() + ": " + questionDTO.getText());

                Output.printCommands(Global.commands);

                commandHandler.setCommands(Global.commands);

                Output.printEnterCommand();

                String userInput = Global.scanner.nextLine();

                shouldContinue = commandHandler.getCommand(userInput).execute();
            }
        }
        return super.execute();
    }
}
