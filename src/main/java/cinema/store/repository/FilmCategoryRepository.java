package cinema.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.FilmCategory;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Long>{

}
