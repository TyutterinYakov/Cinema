package cinema.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.FilmHall;

@Repository
public interface FilmHallRepository extends JpaRepository<FilmHall, Long>{

}
