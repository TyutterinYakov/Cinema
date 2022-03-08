package cinema.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.CinemaEntity;

@Repository
public interface CinemaRepository extends JpaRepository<CinemaEntity, Long> {

}
