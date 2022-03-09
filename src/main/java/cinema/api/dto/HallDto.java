package cinema.api.dto;

import java.util.List;


import cinema.store.entity.CinemaEntity;

public class HallDto {

	
	private Long hallId;
	private String name;
	private List<FilmProjectDto> filmProjectDto;
	
	
	
	public HallDto() {
		super();
	}
	public HallDto(Long hallId, String name, List<FilmProjectDto> filmProjectDto) {
		super();
		this.hallId = hallId;
		this.name = name;
		this.filmProjectDto = filmProjectDto;
	}
	
	
	public HallDto(Long hallId, String name) {
		super();
		this.hallId = hallId;
		this.name = name;
	}
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
	public List<FilmProjectDto> getFilmProjectDto() {
		return filmProjectDto;
	}
	public void setFilmProjectDto(List<FilmProjectDto> filmProjectDto) {
		this.filmProjectDto = filmProjectDto;
	}
	
	
	
	
	
}
