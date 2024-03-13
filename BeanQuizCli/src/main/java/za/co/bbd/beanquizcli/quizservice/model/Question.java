package za.co.bbd.beanquizcli.quizservice.model;

public class Question {
    private long id;
    private long quizId;
    private String text;

    public Question() {
        // Default constructor
    }

    public Question(long id, long quizId, String text) {
        this.id = id;
        this.quizId = quizId;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
