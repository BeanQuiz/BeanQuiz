package za.co.bbd.cli.beanquiz.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserQuizAttempt {
    private Integer quizId;

    private Date startTimestamp;

    private Date endTimestamp;

    private List<UserQuestionResponse> userQuestionResponses = new ArrayList<>();

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public List<UserQuestionResponse> getUserQuestionResponses() {
        return userQuestionResponses;
    }

    public void setUserQuestionResponses(List<UserQuestionResponse> userQuestionResponses) {
        this.userQuestionResponses = userQuestionResponses;
    }
}
