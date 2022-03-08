package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cinema.api.dto.CityDto;
import cinema.store.entity.CityEntity;

@Component
public class CityDtoFactory {

	
	
	public CityDto createCityDto(CityEntity entity) {
		return new CityDto(
				entity.getCityId(), 
				entity.getName());
	}
	
	public List<CityDto> createListCityDto(List<CityEntity> entities){
		return entities
					.stream()
					.map(this::createCityDto)
			   .collect(Collectors.toList());
	}
}
