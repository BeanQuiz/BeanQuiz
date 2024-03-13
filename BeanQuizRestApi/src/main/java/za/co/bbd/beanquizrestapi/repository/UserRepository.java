package za.co.bbd.beanquizrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bbd.beanquizrestapi.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findUserEntityByEmail(String email);
}
