package cinema.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long>{

	Optional<ClientEntity> findByNumClient(String numClient);

}
