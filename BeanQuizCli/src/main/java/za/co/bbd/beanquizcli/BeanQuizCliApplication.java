package za.co.bbd.beanquizcli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import za.co.bbd.beanquizcli.quizcommand.QuizCommand;
import za.co.bbd.beanquizcli.quizservice.QuizService;
import za.co.bbd.beanquizcli.userservice.UserService;

@SpringBootApplication
public class BeanQuizCliApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BeanQuizCliApplication.class, args);
        QuizService quizService = context.getBean(QuizService.class);
        UserService userService = context.getBean(UserService.class);

        // Instantiate QuizCommand with dependencies
        QuizCommand quizCommand = new QuizCommand(userService, quizService);

        // Run the CLI manually
        runCommandLine(quizCommand);
    }

    private static void runCommandLine(QuizCommand quizCommand) {
        // Display welcome message or any initial information
        System.out.println("Welcome to BeanQuiz CLI");
    }
}




