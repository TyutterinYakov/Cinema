package cinema.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	
	
}
