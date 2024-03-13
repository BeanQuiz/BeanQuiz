package za.co.bbd.beanquizcli.quizcommand.model;

public class Quiz {
    private long id;
    private String title;
    private String description;
    private int totalQuestions;

    public Quiz() {
        // Default constructor
    }

    public Quiz(long id, String title, String description, int totalQuestions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.totalQuestions = totalQuestions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
}
