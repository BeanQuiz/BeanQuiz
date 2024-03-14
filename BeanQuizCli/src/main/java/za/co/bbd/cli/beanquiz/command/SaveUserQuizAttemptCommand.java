package za.co.bbd.cli.beanquiz.command;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import za.co.bbd.cli.beanquiz.Global;
import za.co.bbd.cli.beanquiz.model.UserQuizAttempt;

public class SaveUserQuizAttemptCommand extends Command {
    public SaveUserQuizAttemptCommand() {
        super("", "");
    }

    @Override
    public Boolean execute() {
        if (Global.user.isBlank() && Global.accessToken.isBlank()) {
            new LoginCommand().execute();
        }

        UserQuizAttempt userQuizAttempt = new UserQuizAttempt();
        userQuizAttempt.setQuizId(Global.quizId);
        userQuizAttempt.setStartTimestamp(Global.startTimestamp);
        userQuizAttempt.setEndTimestamp(Global.endTimestamp);
        userQuizAttempt.setUserQuestionResponses(Global.userQuestionResponses);

        try {

            HttpResponse<JsonNode> response = Unirest
                    .post(Global.API_DOMAIN + "api/private/user-quiz-attempt")
                    .header("content-type", "application/json")
                    .header("Authorization", Global.accessToken)
                    .body(userQuizAttempt)
                    .asJson();

            if (response.getStatus() != 201) {
                throw new RuntimeException();
            }

        } catch (Exception e) {
            System.out.println("An error occurred...\n");
            return new SaveCommand().execute();
        }

        System.out.println("Quiz attempt saved successfully!\n");

        return new BackCommand().execute();
    }
}
