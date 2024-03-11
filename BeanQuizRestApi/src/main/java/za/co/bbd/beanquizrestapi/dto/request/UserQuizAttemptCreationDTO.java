package za.co.bbd.beanquizrestapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UserQuizAttemptCreationDTO {
    @NotNull
    private Integer quizId;

    @NotNull
    private Date startTimestamp;

    @NotNull
    private Date endTimestamp;

    @NotNull
    @NotEmpty
    private List<UserQuestionResponseCreationDTO> userQuestionResponses;
}
