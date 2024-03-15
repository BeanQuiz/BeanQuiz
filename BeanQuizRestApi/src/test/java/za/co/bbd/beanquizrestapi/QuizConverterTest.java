package za.co.bbd.beanquizrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import za.co.bbd.beanquizrestapi.converter.QuizConverter;
import za.co.bbd.beanquizrestapi.dto.response.QuizDTO;
import za.co.bbd.beanquizrestapi.entity.QuizEntity;

public class QuizConverterTest {

    @Test
    public void testConvertEntityToDTO() {
        // Arrange
        QuizConverter converter = new QuizConverter();
        QuizEntity entity = new QuizEntity();
        entity.setId(1);
        entity.setTitle("Quiz Title");
        entity.setDescription("Quiz Description");
        entity.setTotalQuestions(10);

        // Act
        QuizDTO dto = converter.convertEntityToDTO(entity);

        // Assert
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getTitle(), dto.getTitle());
        assertEquals(entity.getDescription(), dto.getDescription());
        assertEquals(entity.getTotalQuestions(), dto.getTotalQuestions());
    }
}
