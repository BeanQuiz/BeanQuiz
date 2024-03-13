package za.co.bbd.beanquizrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.beanquizrestapi.entity.OptionEntity;

public interface OptionRepository extends JpaRepository<OptionEntity, Integer> {
}
