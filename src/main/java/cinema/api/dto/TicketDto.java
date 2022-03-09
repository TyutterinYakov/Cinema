package cinema.api.dto;

import java.time.LocalDateTime;

public class TicketDto {

	private Long ticketId;
	private String numClient;
	private int place;
	private String film;
	private String hall;
	private LocalDateTime date;
	private double price;
	
	public TicketDto(Long ticketId, String numClient, int place, 
			String film, String hall, LocalDateTime date, double price) {
		super();
		this.ticketId = ticketId;
		this.numClient = numClient;
		this.place = place;
		this.film = film;
		this.hall = hall;
		this.date = date;
		this.price = price;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getNumClient() {
		return numClient;
	}
	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}
	public String getFilm() {
		return film;
	}
	public void setFilm(String film) {
		this.film = film;
	}
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
