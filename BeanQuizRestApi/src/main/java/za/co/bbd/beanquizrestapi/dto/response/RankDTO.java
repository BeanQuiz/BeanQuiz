package za.co.bbd.beanquizrestapi.dto.response;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.beanquizrestapi.dto.IDTO;

@Data
@NoArgsConstructor
public class RankDTO implements IDTO {
    private Integer id;
    private String name;
    private Integer requirement;
    private String funFact;
}
