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
	
	@Autowired
	public FilmProjectDtoFactory(FilmDtoFactory filmDtoFactory) {
		super();
		this.filmDtoFactory = filmDtoFactory;
	}


	public FilmProjectDto createFilmProjectDto(FilmProject project) {
		return new FilmProjectDto(
				project.getId(),
				filmDtoFactory
					.createFilmDto(project.getFilm())
				);
	}
	
	public List<FilmProjectDto> createListFilmProjectDto(List<FilmProject> entities){
		return entities
				.stream()
				.map(this::createFilmProjectDto)
				.collect(Collectors.toList());
	}
}
