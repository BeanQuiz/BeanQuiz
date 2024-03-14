package za.co.bbd.beanquizrestapi.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.bbd.beanquizrestapi.dto.response.OptionDTO;
import za.co.bbd.beanquizrestapi.dto.response.RankDTO;
import za.co.bbd.beanquizrestapi.entity.RankEntity;

@Component
@RequiredArgsConstructor
public class RankConverter implements IConverter<RankDTO, RankEntity>{
    @Override
    public RankEntity convertDTOtoEntity(RankDTO Dto) {
        return null;
    }

    @Override
    public RankDTO convertEntityToDTO(RankEntity entity) {
        RankDTO rankDTO = new RankDTO();
        rankDTO.setId(entity.getId());
        rankDTO.setName(entity.getName());
        rankDTO.setRequirement(entity.getRequirement());
        rankDTO.setFunFact(entity.getFunFact());
        return rankDTO;
    }
}
