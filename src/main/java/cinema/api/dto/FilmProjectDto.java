package cinema.api.dto;

public class FilmProjectDto {

	private Long id;
	private FilmDto filmDto;
	
	public FilmProjectDto() {
		super();
	}
	public FilmProjectDto(Long id, FilmDto filmDto) {
		super();
		this.id = id;
		this.filmDto = filmDto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FilmDto getFilmDto() {
		return filmDto;
	}
	public void setFilmDto(FilmDto filmDto) {
		this.filmDto = filmDto;
	} 
	
	
	
	
	
}
