package za.co.bbd.beanquizcli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OptionDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("questionId")
    private int questionId;

    @JsonProperty("text")
    private String text;

    @JsonProperty("isCorrect")
    private boolean isCorrect;

    private int outputID;
}