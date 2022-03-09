package cinema.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.store.entity.ClientEntity;

@Repository
public interface TicketRepository extends JpaRepository<ClientEntity, Long>{

}
