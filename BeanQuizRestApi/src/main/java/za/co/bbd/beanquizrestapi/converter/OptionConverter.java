package za.co.bbd.beanquizrestapi.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.beanquizrestapi.dto.response.OptionDTO;
import za.co.bbd.beanquizrestapi.entity.OptionEntity;

@Component
@RequiredArgsConstructor
public class OptionConverter implements IConverter<OptionDTO, OptionEntity> {
    @Override
    public OptionEntity convertDTOtoEntity(OptionDTO Dto) {
        return null;
    }

    @Override
    public OptionDTO convertEntityToDTO(OptionEntity entity) {
        OptionDTO optionDTO = new OptionDTO();
        optionDTO.setId(entity.getId());
        optionDTO.setQuestionId(entity.getQuestion().getId());
        optionDTO.setText(entity.getText());
        optionDTO.setIsCorrect(entity.getIsCorrect());
        return optionDTO;
    }
}
