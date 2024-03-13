package za.co.bbd.beanquizrestapi.converter;

import za.co.bbd.beanquizrestapi.dto.IDTO;
import za.co.bbd.beanquizrestapi.entity.IEntity;

public interface IConverter<D extends IDTO, E extends IEntity> {
    public E convertDTOtoEntity(D Dto);

    public D convertEntityToDTO(E entity);
}
