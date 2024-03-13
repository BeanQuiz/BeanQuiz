package za.co.bbd.beanquizcli.quizservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Question {

    /**TO DO: UPDATE ACCORDING TO API CALL**/

    private String question;
    private List<String> options;
    private int correctAnswerIndex;

    public Question() {
        // Default constructor
    }

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = Arrays.asList(options);
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public Question(String question, String[] options) {
        this.question = question;
        this.options = Arrays.asList(options);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex; 
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }

}