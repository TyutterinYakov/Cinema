package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cinema.api.dto.HallDto;
import cinema.store.entity.HallEntity;

@Component
public class HallDtoFactory {

	private final FilmProjectDtoFactory filmProjectDtoFactory;
	
	
	@Autowired
	public HallDtoFactory(FilmProjectDtoFactory filmProjectDtoFactory) {
		super();
		this.filmProjectDtoFactory = filmProjectDtoFactory;
	}



	public HallDto createHallDto(HallEntity hall) {
		return new HallDto(
				hall.getHallId(),
				hall.getName(),
				filmProjectDtoFactory
					.createListFilmProjectDto(
							hall.getFilmProjects())
				);
	}
	
	public List<HallDto> creatListHallDto(List<HallEntity> halls){
		return halls.stream().map((h)->{
			return new HallDto(
					h.getHallId(), 
					h.getName());
			}).collect(Collectors.toList());
	}

	
	
}
