package cinema.api.dto;

public class FilmDto {

	private Long filmId;
	private String title;
	private String description;
	private String image;
	private double duration;
	private String director;
	
	public FilmDto() {
		super();
	}
	public FilmDto(Long filmId, String title, String description, String image, double duration, String director) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.image = image;
		this.duration = duration;
		this.director = director;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	
	
}
