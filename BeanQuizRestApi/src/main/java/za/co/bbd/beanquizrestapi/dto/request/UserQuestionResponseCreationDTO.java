package za.co.bbd.beanquizrestapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserQuestionResponseCreationDTO {
    @NotNull
    private Integer questionId;

    @NotNull
    private Integer selectedOptionId;
}
