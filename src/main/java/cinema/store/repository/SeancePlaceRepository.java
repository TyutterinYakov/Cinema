package cinema.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.ClientEntity;
import cinema.store.entity.SeanceEntity;
import cinema.store.entity.SeancePlace;

@Repository
public interface SeancePlaceRepository extends JpaRepository<SeancePlace, Long>{

	List<SeancePlace> findAllByClient(ClientEntity client);

	Optional<SeancePlace> findByIdAndReserved(Long id, boolean b);

}
