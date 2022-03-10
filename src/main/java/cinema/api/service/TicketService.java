package cinema.api.service;

import java.util.List;

import cinema.api.dto.TicketDto;

public interface TicketService {

	List<TicketDto> getTicketsByNumClient(String numClient);

	List<TicketDto> createNewTickets(Long seanceId, Long[] places);

	void deleteTicket(Long ticketId);

}
