package cinema.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.FilmEntity;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long>{

}
