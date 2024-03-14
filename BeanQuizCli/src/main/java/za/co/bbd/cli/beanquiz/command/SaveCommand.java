package za.co.bbd.cli.beanquiz.command;

import za.co.bbd.cli.beanquiz.Global;
import za.co.bbd.cli.beanquiz.model.UserQuizAttempt;

import java.util.Arrays;
import java.util.Date;

public class SaveCommand extends Command {
    public SaveCommand() {
        super("", "");
    }

    @Override
    public Boolean execute() {
        Global.endTimestamp = new Date();

        System.out.print("\nYour score is (" + Global.score + "\\" + Global.totalQuestions + ")!!!");

        Global.commands = Arrays.asList(
                new DisplayQuestionCommand(
                        "Would you like to save your quiz attempt?",
                        Global.user.isBlank() ? "\u001B[31m(Login Required)\u001B[0m" : "(Username: " + Global.user + ")"
                ),
                new InstanceCommand("Y", "Yes", new SaveUserQuizAttemptCommand()),
                new InstanceCommand("N", "No", new BackCommand())
        );

        return super.execute();
    }
}
