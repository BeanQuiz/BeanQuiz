package za.co.bbd.beanquizrestapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import za.co.bbd.beanquizrestapi.converter.UserQuizAttemptConverter;
import za.co.bbd.beanquizrestapi.dto.response.UserQuizAttemptDTO;
import za.co.bbd.beanquizrestapi.entity.UserQuizAttemptEntity;
import za.co.bbd.beanquizrestapi.entity.UserEntity;
import za.co.bbd.beanquizrestapi.entity.QuizEntity;
import java.util.Date;

public class UserQuizAttemptConverterTest {

    @Test
    public void testConvertEntityToDTO() {
        // Arrange
        UserQuizAttemptConverter converter = new UserQuizAttemptConverter();
        UserQuizAttemptEntity entity = new UserQuizAttemptEntity();
        entity.setId(1);
        UserEntity user = new UserEntity();
        user.setId(2);
        entity.setUser(user);
        QuizEntity quiz = new QuizEntity();
        quiz.setId(3);
        entity.setQuiz(quiz);
        entity.setStartTimestamp(new Date());
        entity.setEndTimestamp(new Date());
        entity.setScore(85);

        // Act
        UserQuizAttemptDTO dto = converter.convertEntityToDTO(entity);

        // Assert
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getUser().getId(), dto.getUserId());
        assertEquals(entity.getQuiz().getId(), dto.getQuizId());
        assertEquals(entity.getStartTimestamp(), dto.getStartTimestamp());
        assertEquals(entity.getEndTimestamp(), dto.getEndTimestamp());
        assertEquals(entity.getScore(), dto.getScore());
    }
}
