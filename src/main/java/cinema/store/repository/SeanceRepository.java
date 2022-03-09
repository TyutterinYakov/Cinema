package cinema.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.SeanceEntity;

@Repository
public interface SeanceRepository extends JpaRepository<SeanceEntity, Long>{

}
