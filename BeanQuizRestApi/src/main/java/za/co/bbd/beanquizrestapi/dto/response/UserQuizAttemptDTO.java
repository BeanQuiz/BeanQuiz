package za.co.bbd.beanquizrestapi.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.beanquizrestapi.dto.IDTO;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserQuizAttemptDTO implements IDTO {
    private Integer id;
    private Integer userId;
    private Integer quizId;
    private Date startTimestamp;
    private Date endTimestamp;
    private Integer score;
}
