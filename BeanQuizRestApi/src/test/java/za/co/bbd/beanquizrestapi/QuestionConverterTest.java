package za.co.bbd.beanquizrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import za.co.bbd.beanquizrestapi.converter.QuestionConverter;
import za.co.bbd.beanquizrestapi.dto.response.QuestionDTO;
import za.co.bbd.beanquizrestapi.entity.QuestionEntity;
import za.co.bbd.beanquizrestapi.entity.QuizEntity;

public class QuestionConverterTest {

    @Test
    public void testConvertEntityToDTO() {
        // Arrange
        QuestionConverter converter = new QuestionConverter();
        QuestionEntity entity = new QuestionEntity();
        entity.setId(1);
        QuizEntity quiz = new QuizEntity();
        quiz.setId(2);
        entity.setQuiz(quiz);
        entity.setText("Question Text");

        // Act
        QuestionDTO dto = converter.convertEntityToDTO(entity);

        // Assert
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getQuiz().getId(), dto.getQuizId());
        assertEquals(entity.getText(), dto.getText());
    }
}