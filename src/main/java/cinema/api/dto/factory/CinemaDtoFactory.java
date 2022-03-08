package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cinema.api.dto.CinemaDto;
import cinema.store.entity.CinemaEntity;

@Component
public class CinemaDtoFactory {

	
	public CinemaDto createCinemaDto(CinemaEntity entity) {
		
		return new CinemaDto(
				entity.getCinemaId(), 
				entity.getName(), 
				entity.getDescription(), 
				entity.getCity().getName(), 
				entity.getStreet(), 
				entity.getStructure(), 
				entity.getStructure());
	}
	
	public List<CinemaDto> createListCinemaDto(List<CinemaEntity> entities){
		return entities
					.stream()
					.map(this::createCinemaDto)
			   .collect(Collectors.toList());
	}
}
