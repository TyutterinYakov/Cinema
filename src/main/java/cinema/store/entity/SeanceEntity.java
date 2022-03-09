package cinema.store.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="seance")
public class SeanceEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seanceId;
	private LocalDateTime startedAt;
	private LocalDateTime stopedAt;
	@OneToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private FilmProject filmProject;
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
	public FilmProject getFilmProject() {
		return filmProject;
	}
	public void setFilmProject(FilmProject filmProject) {
		this.filmProject = filmProject;
	}
	
	
	
	
	
	
	
}
