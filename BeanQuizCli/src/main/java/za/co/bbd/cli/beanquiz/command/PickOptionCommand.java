package za.co.bbd.cli.beanquiz.command;

import kong.unirest.json.JSONObject;
import za.co.bbd.cli.beanquiz.Global;
import za.co.bbd.cli.beanquiz.model.UserQuestionResponse;

public class PickOptionCommand extends Command {
    private final String optionId;
    private final Boolean isCorrect;

    public PickOptionCommand(String identifier, String description, String optionId, Boolean isCorrect) {
        super(identifier, description);
        this.optionId = optionId;
        this.isCorrect = isCorrect;
    }

    @Override
    public Boolean execute() {
        UserQuestionResponse userQuestionResponse = new UserQuestionResponse();
        userQuestionResponse.setSelectedOptionId(Integer.parseInt(this.optionId));
        Global.userQuestionResponses.add(userQuestionResponse);

        if (isCorrect) {
            Global.score += 1;
        }

        if (Global.questions.isEmpty()) {
            return new SaveCommand().execute();
        }

        JSONObject question = Global.questions.removeFirst();

        return new AnswerQuestionCommand(question.getString("id"), question.getString("text")).execute();
    }
}
