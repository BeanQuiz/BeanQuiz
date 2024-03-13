package za.co.bbd.beanquizrestapi.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.beanquizrestapi.dto.response.UserDTO;
import za.co.bbd.beanquizrestapi.entity.UserEntity;

@Component
@RequiredArgsConstructor
public class UserConverter implements IConverter<UserDTO, UserEntity> {
    @Override
    public UserEntity convertDTOtoEntity(UserDTO Dto) {
        return null;
    }

    @Override
    public UserDTO convertEntityToDTO(UserEntity entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setUsername(entity.getUsername());
        userDTO.setEmail(entity.getEmail());
        return userDTO;
    }
}
