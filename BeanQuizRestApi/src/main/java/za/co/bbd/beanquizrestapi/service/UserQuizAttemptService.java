package za.co.bbd.beanquizrestapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import za.co.bbd.beanquizrestapi.converter.UserQuizAttemptConverter;
import za.co.bbd.beanquizrestapi.dto.request.UserQuizAttemptCreationDTO;
import za.co.bbd.beanquizrestapi.dto.response.UserQuizAttemptDTO;
import za.co.bbd.beanquizrestapi.entity.*;
import za.co.bbd.beanquizrestapi.exception.BusinessException;
import za.co.bbd.beanquizrestapi.repository.*;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserQuizAttemptService {
    private final UserRepository userRepository;
    private final OptionRepository optionRepository;
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final UserQuizAttemptRepository userQuizAttemptRepository;
    private final UserQuestionResponseRepository userQuestionResponseRepository;
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

    public void saveUserQuizAttempt(Integer userId, UserQuizAttemptCreationDTO userQuizAttemptCreationDTO) {
        QuizEntity quizEntity = quizRepository
                .findById(userQuizAttemptCreationDTO.getQuizId())
                .orElseThrow(() -> new BusinessException("Invalid QuizId", HttpStatus.BAD_REQUEST));

        if (userQuizAttemptCreationDTO.getUserQuestionResponses().size() != quizEntity.getTotalQuestions()) {
            throw new BusinessException("Invalid number of question responses provided", HttpStatus.BAD_REQUEST);
        }

        Integer quizId = quizEntity.getId();

        List<OptionEntity> selectedOptions = userQuizAttemptCreationDTO
                .getUserQuestionResponses()
                .stream()
                .map(option -> {
                    OptionEntity optionEntity = optionRepository
                            .findById(option.getSelectedOptionId())
                            .orElseThrow(() -> new BusinessException(
                                            "Invalid selectedOptionId provided",
                                            HttpStatus.BAD_REQUEST
                                    )
                            );

                    if (!Objects.equals(optionEntity.getQuestion().getQuiz().getId(), quizId)) {
                        throw new BusinessException(
                                "Invalid selectedOptionId provided",
                                HttpStatus.BAD_REQUEST
                        );
                    }

                    return optionEntity;
                }).toList();

        Integer score = Math.toIntExact(selectedOptions.stream().filter(OptionEntity::getIsCorrect).count());

        UserEntity userEntity = userRepository.findById(userId).get();

        UserQuizAttemptEntity userQuizAttemptEntity = new UserQuizAttemptEntity();
        userQuizAttemptEntity.setUser(userEntity);
        userQuizAttemptEntity.setQuiz(quizEntity);
        userQuizAttemptEntity.setStartTimestamp(userQuizAttemptCreationDTO.getStartTimestamp());
        userQuizAttemptEntity.setEndTimestamp(userQuizAttemptCreationDTO.getEndTimestamp());
        userQuizAttemptEntity.setScore(score);
        userQuizAttemptRepository.save(userQuizAttemptEntity);

        selectedOptions.stream().peek(optionEntity -> {
            UserQuestionResponseEntity userQuestionResponseEntity = new UserQuestionResponseEntity();
            userQuestionResponseEntity.setAttempt(userQuizAttemptEntity);
            userQuestionResponseEntity.setOption(optionEntity);
            userQuestionResponseRepository.save(userQuestionResponseEntity);
        });
    }
}
