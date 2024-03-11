package za.co.bbd.beanquizrestapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import za.co.bbd.beanquizrestapi.converter.UserQuizAttemptConverter;
import za.co.bbd.beanquizrestapi.dto.response.UserQuizAttemptDTO;
import za.co.bbd.beanquizrestapi.entity.UserQuizAttemptEntity;
import za.co.bbd.beanquizrestapi.exception.BusinessException;
import za.co.bbd.beanquizrestapi.repository.UserQuizAttemptRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserQuizAttemptService {
    private final UserQuizAttemptRepository userQuizAttemptRepository;
    private final UserQuizAttemptConverter userQuizAttemptConverter;

    public UserQuizAttemptDTO getUserQuizAttempt(Integer userId, Integer attemptId) {
        UserQuizAttemptEntity userQuizAttemptEntity = userQuizAttemptRepository
                .findById(attemptId)
                .orElseThrow(
                        () -> new BusinessException(
                                "Unable to find User Quiz Attempt with ID: " + attemptId,
                                HttpStatus.NOT_FOUND
                        )
                );

        if (!Objects.equals(userId, userQuizAttemptEntity.getUser().getId())) {
            throw new BusinessException(
                    "Unable to find Quiz Attempt with ID: " + attemptId + ", for User with ID: " + userId,
                    HttpStatus.NOT_FOUND
            );
        }

        return userQuizAttemptConverter.convertEntityToDTO(userQuizAttemptEntity);
    }

    public List<UserQuizAttemptDTO> getUserQuizAttempts(Integer userId) {
        return userQuizAttemptRepository
                .findAll()
                .stream()
                .filter(userQuizAttemptEntity -> Objects.equals(userId, userQuizAttemptEntity.getUser().getId()))
                .map(userQuizAttemptConverter::convertEntityToDTO)
                .toList();
    }

    public List<UserQuizAttemptDTO> getUserQuizAttemptsForQuiz(Integer userId, Integer quizId) {
        return userQuizAttemptRepository
                .findAll()
                .stream()
                .filter(userQuizAttemptEntity ->
                        Objects.equals(userId, userQuizAttemptEntity.getUser().getId())
                                &&
                                Objects.equals(quizId, userQuizAttemptEntity.getQuiz().getId())
                )
                .map(userQuizAttemptConverter::convertEntityToDTO)
                .toList();
    }
}
