package za.co.bbd.beanquizrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.beanquizrestapi.entity.QuestionEntity;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
}
