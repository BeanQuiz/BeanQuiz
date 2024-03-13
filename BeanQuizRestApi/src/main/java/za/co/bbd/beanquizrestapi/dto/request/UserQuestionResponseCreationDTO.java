package za.co.bbd.beanquizrestapi.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserQuestionResponseCreationDTO {
    @NotNull
    private Integer selectedOptionId;
}
