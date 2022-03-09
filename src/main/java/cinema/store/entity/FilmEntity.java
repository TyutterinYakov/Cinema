package cinema.store.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="film")
public class FilmEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long filmId;
	private String title;
	@Column(length=3000)
	private String descrition;
	private String image;
	private String director;
	private double duration;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="film")
	private List<FilmCategory> filmCategory = new ArrayList<>();
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="film")
	private List<FilmHall> filmHall = new ArrayList<>();
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="film")
	private List<FilmProject> filmProjects = new ArrayList<>();
	
	
	public Long getFilmId() {
		return filmId;
	}
	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public List<FilmHall> getFilmHall() {
		return filmHall;
	}
	public void setFilmHall(List<FilmHall> filmHall) {
		this.filmHall = filmHall;
	}
	public List<FilmCategory> getFilmCategory() {
		return filmCategory;
	}
	public void setFilmCategory(List<FilmCategory> filmCategory) {
		this.filmCategory = filmCategory;
	}
	public List<FilmProject> getFilmProjects() {
		return filmProjects;
	}
	public void setFilmProjects(List<FilmProject> filmProjects) {
		this.filmProjects = filmProjects;
	}
	
	
	
	
	
	
	
	
}
