package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cinema.api.dto.FilmDto;
import cinema.store.entity.FilmEntity;

@Component
public class FilmDtoFactory {

	
	
	public FilmDto createFilmDto(FilmEntity entity) {
		return new FilmDto(
				entity.getFilmId(), 
				entity.getTitle(), 
				entity.getDescrition(), 
				entity.getImage(), 
				entity.getDuration(), 
				entity.getDirector());
	}
	
	public List<FilmDto> createListFilmDto(List<FilmEntity> entities){
		
		return entities
				.stream()
				.map(this::createFilmDto)
				.collect(Collectors.toList());
	}
}
