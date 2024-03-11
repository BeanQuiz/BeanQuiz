package za.co.bbd.beanquizrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.beanquizrestapi.entity.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer> {
}
