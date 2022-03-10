package cinema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.api.dto.TicketDto;
import cinema.api.service.TicketService;

@RestController
@CrossOrigin("*")
public class TicketController {

	private final TicketService ticketService;

	@Autowired
	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}
	
	public final String GET_TICKETS_BY_NUM_CLIENT = "/api/tickets/{numClient}";
	public final String ADD_TICKET_BY_SEANCE = "/api/tickets/seance/{seanceId}";
	public final String DELETE_TICKET = "/api/tickets/{ticketId}";
	
	
	@GetMapping(GET_TICKETS_BY_NUM_CLIENT)
	public ResponseEntity<List<TicketDto>> getTicketsByNumClient(
			@PathVariable("numClient") String numClient){
		return ResponseEntity.ok(
				ticketService.getTicketsByNumClient(numClient));
	}
	
	@PostMapping(ADD_TICKET_BY_SEANCE)
	public ResponseEntity<List<TicketDto>> addTickets(
			@PathVariable("seanceId") Long seanceId, @RequestBody Long[] places){
		return new ResponseEntity<>(
				ticketService.createNewTickets(seanceId, places), HttpStatus.CREATED);
	}
	
	@DeleteMapping(DELETE_TICKET)
	public ResponseEntity<?> deleteTicket(@PathVariable("ticketId") Long ticketId){
		ticketService.deleteTicket(ticketId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
