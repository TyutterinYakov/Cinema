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
import javax.persistence.Table;

@Entity
@Table(name="hall")
public class HallEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long hallId;
	private String name;
	private int countPlace;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private CinemaEntity cinema;
	@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY, mappedBy="hall")
	private List<PlaceEntity> places = new ArrayList<>();
	@OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY, mappedBy="hall")
	private List<FilmHall> filmHall = new ArrayList<>();
	
	
	public Long getHallId() {
		return hallId;
	}
	public void setHallId(Long hallId) {
		this.hallId = hallId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCountPlace() {
		return countPlace;
	}
	public void setCountPlace(int countPlace) {
		this.countPlace = countPlace;
	}
	public CinemaEntity getCinema() {
		return cinema;
	}
	public void setCinema(CinemaEntity cinema) {
		this.cinema = cinema;
	}
	public List<PlaceEntity> getPlaces() {
		return places;
	}
	public void setPlaces(List<PlaceEntity> places) {
		this.places = places;
	}
	public List<FilmHall> getFilmHall() {
		return filmHall;
	}
	public void setFilmHall(List<FilmHall> filmHall) {
		this.filmHall = filmHall;
	}
	
	
	
	
}
