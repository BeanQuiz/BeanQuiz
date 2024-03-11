package za.co.bbd.beanquizrestapi.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.bbd.beanquizrestapi.dto.IDTO;

@Data
@NoArgsConstructor
public class UserDTO implements IDTO {
    private Integer id;
    private String username;
    private String email;
}
