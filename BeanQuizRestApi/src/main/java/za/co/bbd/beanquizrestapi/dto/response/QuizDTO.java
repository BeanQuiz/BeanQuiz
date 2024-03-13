package za.co.bbd.beanquizrestapi.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.beanquizrestapi.dto.IDTO;

@Data
@NoArgsConstructor
public class QuizDTO implements IDTO {
    private Integer id;
    private String title;
    private String description;
    private Integer totalQuestions;
}
