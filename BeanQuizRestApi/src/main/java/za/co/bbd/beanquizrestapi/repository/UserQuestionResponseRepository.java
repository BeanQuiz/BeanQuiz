package za.co.bbd.beanquizrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.beanquizrestapi.entity.UserQuestionResponseEntity;

public interface UserQuestionResponseRepository extends JpaRepository<UserQuestionResponseEntity, Integer> {
}
