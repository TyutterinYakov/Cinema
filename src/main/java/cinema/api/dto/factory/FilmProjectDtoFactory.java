package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cinema.api.dto.FilmProjectDto;
import cinema.store.entity.FilmProject;

@Component
public class FilmProjectDtoFactory {
	
	private final FilmDtoFactory filmDtoFactory;
	private final SeanceDtoFactory seanceDtoFactory;
	
	@Autowired
	public FilmProjectDtoFactory(FilmDtoFactory filmDtoFactory, SeanceDtoFactory seanceDtoFactory) {
		super();
		this.filmDtoFactory = filmDtoFactory;
		this.seanceDtoFactory = seanceDtoFactory;
	}

	public FilmProjectDto createFilmProjectDto(FilmProject project) {
		return new FilmProjectDto(
				project.getId(),
				filmDtoFactory
					.createFilmDto(project.getFilm()),
				seanceDtoFactory
					.createSeanceDto(project.getSeance())
				);
	}
	
	public List<FilmProjectDto> createListFilmProjectDto(List<FilmProject> entities){
		return entities
				.stream()
				.map(this::createFilmProjectDto)
				.collect(Collectors.toList());
	}
}
