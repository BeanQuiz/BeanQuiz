package za.co.bbd.beanquizrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.beanquizrestapi.entity.UserQuizAttemptEntity;

public interface UserQuizAttemptRepository extends JpaRepository<UserQuizAttemptEntity, Integer> {
}
