package za.co.bbd.beanquizcli.quizservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class QuizService {

    private List<Question> quizQuestions;
    private int score;

    public QuizService(@Autowired List<Question> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************************");
        System.out.println("*                  Quiz Game                  *");
        System.out.println("***********************************************");
        System.out.println("Rules: Answer the following questions. Enter the number of the correct answer. Type 'quit' to exit at any time.");

        for (Question question : quizQuestions) {
            System.out.println(question.getQuestion());
            System.out.println("Options:");
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Your choice: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > options.size()) {
                    System.out.println("Invalid choice. Please select a number between 1 and " + options.size());
                } else {
                    int correctAnswerIndex = question.getCorrectAnswerIndex();
                    if (choice - 1 == correctAnswerIndex) {
                        score++;
                        System.out.println("Correct!");
                    } else {
                        System.out.println("Wrong! The correct answer is: " + (correctAnswerIndex + 1) + ". " + options.get(correctAnswerIndex));
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'quit' to exit.");
            }
        }

        System.out.println("***********************************************");
        System.out.println("*                  Quiz Results               *");
        System.out.println("***********************************************");
        System.out.println("Total score: " + score + " out of " + quizQuestions.size());
        System.out.println("Thank you for playing!");

        scanner.close();
    }

    public List<Question> populateQuestions() {
        List<Question> questions = new ArrayList<>();
        /**TO DO: IMPLEMENT API CALL**/
        questions = getBeanQuestionsMockData();
        return questions;
    }

    public List<Question> getBeanQuestions() {
        List<Question> questions = new ArrayList<>();
        /**API: IMPLEMENT GET FROM DB**/
        return questions;
    }

    public List<Question> getBeanQuestionsMockData() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
            "What type of beans are commonly used to make baked beans?",
            new String[]{"Navy beans", "Kidney beans", "Black beans", "Pinto beans"},
            0));

        questions.add(new Question(
            "Besides beans, what are the main ingredients in baked beans?",
            new String[]{"Molasses, mustard, onion", "Tomatoes, garlic, oregano", "Soy sauce, ginger, sesame oil", "Brown sugar, bacon, ketchup"},
            3));

        questions.add(new Question(
            "How are baked beans typically cooked?",
            new String[]{"Fried in a pan", "Baked in the oven", "Steamed on the stove-top", "Deep fried"},
            1));

        return questions;
    }
}

