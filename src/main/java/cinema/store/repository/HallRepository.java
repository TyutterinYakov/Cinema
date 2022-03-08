package cinema.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.HallEntity;

@Repository
public interface HallRepository extends JpaRepository<HallEntity, Long>{

}
