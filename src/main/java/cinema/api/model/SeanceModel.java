package cinema.api.model;

import java.time.LocalDateTime;

public class SeanceModel {

	private LocalDateTime startedAt;
	private Long filmId;
	private double price;
	
	public LocalDateTime getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
