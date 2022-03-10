package cinema.api.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.api.dto.TicketDto;
import cinema.api.dto.factory.TicketDtoFactory;
import cinema.api.exception.NotFoundException;
import cinema.api.service.TicketService;
import cinema.store.entity.ClientEntity;
import cinema.store.entity.SeanceEntity;
import cinema.store.entity.SeancePlace;
import cinema.store.repository.ClientRepository;
import cinema.store.repository.SeancePlaceRepository;
import cinema.store.repository.SeanceRepository;

@Service
public class TicketServiceImpl implements TicketService{

	private final SeancePlaceRepository seancePlaceDao;
	private final ClientRepository clientDao;
	private final TicketDtoFactory ticketDtoFactory;
	private final SeanceRepository seanceDao;
	
	
	@Autowired
	public TicketServiceImpl(SeancePlaceRepository seancePlaceDao, ClientRepository clientDao,
			TicketDtoFactory ticketDtoFactory, SeanceRepository seanceDao) {
		super();
		this.seancePlaceDao = seancePlaceDao;
		this.clientDao = clientDao;
		this.ticketDtoFactory = ticketDtoFactory;
		this.seanceDao = seanceDao;
	}

	@Override
	public List<TicketDto> getTicketsByNumClient(String numClient) {
		ClientEntity client = findClientByNumClient(numClient);
		return ticketDtoFactory
				.createListTicketDto(
						seancePlaceDao.findAllByClient(client));
	}

	@Override
	public List<TicketDto> createNewTickets(Long seanceId, Long[] places) {
		SeanceEntity seance = seanceDao
				.findBySeanceIdAndStartedAtAfter(seanceId, LocalDateTime.now()).orElseThrow(()->
						new NotFoundException(
								String.format(
										"Сеанс уже начался или его не существует \"%s\" ", 
										seanceId)));
		Arrays.stream(places).map(this::findSeancePlaceByIdAndReserved).collect(Collectors.toList());
		String numClient = UUID.randomUUID().toString().substring(0, 8);
		List<SeancePlace> tickets = Arrays
									.stream(places)
									.map(this::findSeancePlaceByIdAndReserved)
									.collect(Collectors.toList());
		clientDao.save(new ClientEntity(numClient, tickets));
		return ticketDtoFactory.createListTicketDto(tickets);
	}

	@Override
	@Transactional
	public void deleteTicket(Long ticketId) {
		SeancePlace ticket = findSeancePlaceById(ticketId);
		ticket.setReserved(false);
		ticket.setClient(null);
	}
	
	
	
	private ClientEntity findClientByNumClient(String numClient) {
		return clientDao.findByNumClient(numClient).orElseThrow(()->
				new NotFoundException(
						String.format("Клиент с номером \"%s\" не найден", numClient)));
	}
	
	private SeancePlace findSeancePlaceById(Long ticketId) {
		return seancePlaceDao.findById(ticketId).orElseThrow(()->
				new NotFoundException(
						String.format("Билет с идентификатором \"%s\" не найден", ticketId)));
	}
	
	private SeancePlace findSeancePlaceByIdAndReserved(Long id) {
		return seancePlaceDao.findByIdAndReserved(id, false).orElseThrow(()->
				new NotFoundException(
						String.format("Место с идентификатором \"%s\" не найдено или оно уже забронировано", 
								id)));
	}

}
