package za.co.bbd.beanquizrestapi.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.beanquizrestapi.dto.response.QuestionDTO;
import za.co.bbd.beanquizrestapi.entity.QuestionEntity;

@Component
@RequiredArgsConstructor
public class QuestionConverter implements IConverter<QuestionDTO, QuestionEntity> {

    @Override
    public QuestionEntity convertDTOtoEntity(QuestionDTO Dto) {
        return null;
    }

    @Override
    public QuestionDTO convertEntityToDTO(QuestionEntity questionEntity) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(questionEntity.getId());
        questionDTO.setQuizId(questionEntity.getQuiz().getId());
        questionDTO.setText(questionEntity.getText());
        return questionDTO;
    }
}
