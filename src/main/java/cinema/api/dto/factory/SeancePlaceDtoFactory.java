package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cinema.api.dto.SeancePlaceDto;
import cinema.store.entity.SeancePlace;

@Component
public class SeancePlaceDtoFactory {

	
	public SeancePlaceDto createSeancePlaceDto(SeancePlace entity) {
		return new SeancePlaceDto(
				entity.getId(), 
				entity.isReserved(),
				entity.getPlace().getNumber());
	}
	
	public List<SeancePlaceDto> createListSeancePlaceDto(List<SeancePlace> list){
		return list
				.stream()
				.map(this::createSeancePlaceDto)
				.collect(Collectors.toList());
	}
	
	
}
