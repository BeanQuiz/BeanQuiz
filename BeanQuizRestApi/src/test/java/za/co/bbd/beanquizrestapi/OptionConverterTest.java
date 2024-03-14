package za.co.bbd.beanquizrestapi;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import za.co.bbd.beanquizrestapi.converter.OptionConverter;
import za.co.bbd.beanquizrestapi.dto.response.OptionDTO;
import za.co.bbd.beanquizrestapi.entity.OptionEntity;
import za.co.bbd.beanquizrestapi.entity.QuestionEntity;

import static org.junit.Assert.*;

@SpringBootTest
public class OptionConverterTest {

    @Test
    public void testConvertEntityToDTO() {
        // Arrange
        OptionConverter converter = new OptionConverter();
        OptionEntity entity = new OptionEntity();
        entity.setId(1);
        QuestionEntity question = new QuestionEntity();
        question.setId(2);
        entity.setQuestion(question);
        entity.setText("Option Text");
        entity.setIsCorrect(true);

        // Act
        OptionDTO dto = converter.convertEntityToDTO(entity);

        // Assert
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getQuestion().getId(), dto.getQuestionId());
        assertEquals(entity.getText(), dto.getText());
        assertEquals(entity.getIsCorrect(), dto.getIsCorrect());
    }
}
