package za.co.bbd.beanquizrestapi.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.beanquizrestapi.dto.response.QuizDTO;
import za.co.bbd.beanquizrestapi.entity.QuizEntity;

@Component
@RequiredArgsConstructor
public class QuizConverter implements IConverter<QuizDTO, QuizEntity> {
    @Override
    public QuizEntity convertDTOtoEntity(QuizDTO Dto) {
        return null;
    }

    @Override
    public QuizDTO convertEntityToDTO(QuizEntity quizEntity) {
        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setId(quizEntity.getId());
        quizDTO.setTitle(quizEntity.getTitle());
        quizDTO.setDescription(quizEntity.getDescription());
        quizDTO.setTotalQuestions(quizEntity.getTotalQuestions());
        return quizDTO;
    }
}
