package cinema.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.CategoryEntity;
import cinema.store.entity.FilmCategory;
import cinema.store.entity.FilmEntity;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory, Long>{

	List<FilmCategory> findAllByCategory(CategoryEntity category);

}
