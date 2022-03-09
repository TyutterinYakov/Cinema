package cinema.api.dto;

import java.time.LocalDateTime;

public class SeanceDto {

	private Long seanceId;
	private LocalDateTime startedAt;
	private LocalDateTime stopedAt;
	private FilmDto filmDto;
	private double price;
	
	public SeanceDto() {
		super();
	}
	public SeanceDto(Long seanceId, LocalDateTime startedAt, 
			LocalDateTime stopedAt, FilmDto filmDto, double price) {
		super();
		this.seanceId = seanceId;
		this.startedAt = startedAt;
		this.stopedAt = stopedAt;
		this.filmDto = filmDto;
		this.price = price;
	}
	public Long getSeanceId() {
		return seanceId;
	}
	public void setSeanceId(Long seanceId) {
		this.seanceId = seanceId;
	}
	public LocalDateTime getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}
	public LocalDateTime getStopedAt() {
		return stopedAt;
	}
	public void setStopedAt(LocalDateTime stopedAt) {
		this.stopedAt = stopedAt;
	}
	public FilmDto getFilmDto() {
		return filmDto;
	}
	public void setFilmDto(FilmDto filmDto) {
		this.filmDto = filmDto;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
	
}
