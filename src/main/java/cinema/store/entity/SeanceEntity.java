package cinema.store.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="seance")
public class SeanceEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seanceId;
	private LocalDateTime startedAt;
	private LocalDateTime stopedAt;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private HallEntity hall;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private FilmEntity film;
	private Double price;
	
	public SeanceEntity() {
		super();
	}
	public SeanceEntity(LocalDateTime startedAt, LocalDateTime stopedAt, HallEntity hall, FilmEntity film, Double price) {
		super();
		this.startedAt = startedAt;
		this.stopedAt = stopedAt;
		this.hall = hall;
		this.film = film;
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
	public HallEntity getHall() {
		return hall;
	}
	public void setHall(HallEntity hall) {
		this.hall = hall;
	}
	public FilmEntity getFilm() {
		return film;
	}
	public void setFilm(FilmEntity film) {
		this.film = film;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	
	
	
}
