package za.co.bbd.beanquizrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.bbd.beanquizrestapi.entity.RankEntity;

public interface RankRepository extends JpaRepository<RankEntity, Integer>  {
}
