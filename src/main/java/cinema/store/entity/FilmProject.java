package cinema.store.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FilmProject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private HallEntity hall;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private FilmEntity film;
	@OneToMany(mappedBy="filmProject", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	private List<SeanceEntity> seances = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public List<SeanceEntity> getSeances() {
		return seances;
	}
	public void setSeances(List<SeanceEntity> seances) {
		this.seances = seances;
	}
	
	
	
	
}
