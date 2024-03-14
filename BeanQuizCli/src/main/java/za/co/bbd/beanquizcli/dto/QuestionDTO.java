package za.co.bbd.beanquizcli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuestionDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("quizId")
    private int quizId;

    @JsonProperty("text")
    private String text;
}
