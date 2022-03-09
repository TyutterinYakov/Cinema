package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cinema.api.dto.SeanceDto;
import cinema.store.entity.SeanceEntity;

@Component
public class SeanceDtoFactory {
	
	public SeanceDto createSeanceDto(SeanceEntity entity) {
		return new SeanceDto(
				entity.getSeanceId(), 
				entity.getStartedAt(), 
				entity.getStopedAt());
	}
	
	public List<SeanceDto> createListSeanceDto(List<SeanceEntity> entities){
		return entities
				.stream()
				.map(this::createSeanceDto)
				.collect(Collectors.toList());
	}
	
}
