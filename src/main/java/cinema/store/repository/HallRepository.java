package cinema.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.CinemaEntity;
import cinema.store.entity.HallEntity;

@Repository
public interface HallRepository extends JpaRepository<HallEntity, Long>{

	Optional<HallEntity> findByNameIgnoreCaseAndCinema(String name, CinemaEntity cinema);

}
