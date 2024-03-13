package za.co.bbd.beanquizrestapi.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.beanquizrestapi.dto.response.UserQuizAttemptDTO;
import za.co.bbd.beanquizrestapi.entity.UserQuizAttemptEntity;

@Component
@RequiredArgsConstructor
public class UserQuizAttemptConverter implements IConverter<UserQuizAttemptDTO, UserQuizAttemptEntity> {
    @Override
    public UserQuizAttemptEntity convertDTOtoEntity(UserQuizAttemptDTO Dto) {
        return null;
    }

    @Override
    public UserQuizAttemptDTO convertEntityToDTO(UserQuizAttemptEntity entity) {
        UserQuizAttemptDTO userQuizAttemptDTO = new UserQuizAttemptDTO();
        userQuizAttemptDTO.setId(entity.getId());
        userQuizAttemptDTO.setQuizId(entity.getQuiz().getId());
        userQuizAttemptDTO.setUserId(entity.getUser().getId());
        userQuizAttemptDTO.setStartTimestamp(entity.getStartTimestamp());
        userQuizAttemptDTO.setEndTimestamp(entity.getEndTimestamp());
        userQuizAttemptDTO.setScore(entity.getScore());
        return userQuizAttemptDTO;
    }
}
