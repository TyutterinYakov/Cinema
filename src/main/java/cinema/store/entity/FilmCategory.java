package cinema.store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FilmCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private FilmEntity film;
	@ManyToOne
	private CategoryEntity category;
	
	
	
	public FilmCategory() {
		super();
	}
	public FilmCategory(FilmEntity film, CategoryEntity category) {
		super();
		this.film = film;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FilmEntity getFilm() {
		return film;
	}
	public void setFilm(FilmEntity film) {
		this.film = film;
	}
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	
	
	
}
