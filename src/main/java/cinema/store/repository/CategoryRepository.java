package cinema.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import cinema.store.entity.CategoryEntity;
import cinema.store.entity.CinemaEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{


	Optional<CategoryEntity> findByCinemaAndNameIgnoreCase(CinemaEntity cinema, String name);

}
