package cinema.api.dto;


public class FilmProjectDto {

	private Long id;
	private FilmDto filmDto;
	private SeanceDto seance;
	
	public FilmProjectDto() {
		super();
	}
	
	public FilmProjectDto(Long id, FilmDto filmDto, SeanceDto seance) {
		super();
		this.id = id;
		this.filmDto = filmDto;
		this.seance = seance;
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

	public SeanceDto getSeance() {
		return seance;
	}

	public void setSeance(SeanceDto seance) {
		this.seance = seance;
	}

	
	
	
	
	
	
}
