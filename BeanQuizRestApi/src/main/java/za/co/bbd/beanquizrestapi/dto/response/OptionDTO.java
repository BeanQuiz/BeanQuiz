package za.co.bbd.beanquizrestapi.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.beanquizrestapi.dto.IDTO;

@Data
@NoArgsConstructor
public class OptionDTO implements IDTO {
    private Integer id;
    private Integer questionId;
    private String text;
    private Boolean isCorrect;
}
