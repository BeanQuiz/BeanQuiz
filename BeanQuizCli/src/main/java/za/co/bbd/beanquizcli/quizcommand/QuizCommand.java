package za.co.bbd.beanquizcli.quizcommand;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import za.co.bbd.beanquizcli.quizservice.QuizService;
import za.co.bbd.beanquizcli.userservice.UserService;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

// @Command(name = "quizCommand", mixinStandardHelpOptions = true, version = "1.0", description = "A simple CLI quiz game")
public class QuizCommand implements Runnable {

    // @Option(names = {"-u", "--username"}, description = "Username")
    private String username;

    // @Option(names = {"-p", "--password"}, description = "Password")
    private String password;

    private UserService userService;
    private QuizService quizService;

    @Autowired
    public QuizCommand(UserService userService, QuizService quizService) {
        this.userService = userService;
        this.quizService = quizService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("*                                             *");
        System.out.println("*            Welcome to CLI Quiz Game!        *");
        System.out.println("*                                             *");
        System.out.println("***********************************************");

        System.out.println("Choose an option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                System.out.println("Thank you for playing! Goodbye!");
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("*                Register User                *");
        System.out.println("***********************************************");

        /** TODO: IMPLEMENT AUTH **/
        System.out.print("Enter username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String newPassword = scanner.nextLine();

        userService.registerUser(newUsername, newPassword);

        System.out.println("User registered successfully.");
        scanner.close();
    }

    private void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("*                   Login                     *");
        System.out.println("***********************************************");

        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        boolean authenticated = userService.authenticateUser(inputUsername, inputPassword);

        if (authenticated) {
            System.out.println("Welcome, " + inputUsername + "!");
            // Logic for user
            startQuiz();
        } else {
            System.out.println("Invalid username or password.");
        }
        scanner.close();
    }

    private void startQuiz() {
        quizService.startQuiz();
    }
}

