package cinema.api.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class SeanceModel {

	@NotNull
	private LocalDateTime startedAt;
	@NotNull
	private Long filmId;
	@NotNull
	private Double price;
	
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
