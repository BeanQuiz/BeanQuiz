package za.co.bbd.beanquizrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import za.co.bbd.beanquizrestapi.converter.UserConverter;
import za.co.bbd.beanquizrestapi.dto.response.UserDTO;
import za.co.bbd.beanquizrestapi.entity.UserEntity;

public class UserConverterTest {

    @Test
    public void testConvertEntityToDTO() {
        // Arrange
        UserConverter converter = new UserConverter();
        UserEntity entity = new UserEntity();
        entity.setId(1);
        entity.setUsername("Test User");
        entity.setEmail("testuser@example.com");

        // Act
        UserDTO dto = converter.convertEntityToDTO(entity);

        // Assert
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getUsername(), dto.getUsername());
        assertEquals(entity.getEmail(), dto.getEmail());
    }
}
