package za.co.bbd.beanquizrestapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsernameDTO {
    @NotNull
    @NotBlank
    private String username;
}
