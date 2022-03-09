package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cinema.api.dto.HallDto;
import cinema.store.entity.HallEntity;

@Component
public class HallDtoFactory {

	private final SeanceDtoFactory seanceDtoFactory;
	
	@Autowired
	public HallDtoFactory(SeanceDtoFactory seanceDtoFactory) {
		super();
		this.seanceDtoFactory = seanceDtoFactory;
	}

	public HallDto createHallDto(HallEntity hall) {
		return new HallDto(
				hall.getHallId(),
				hall.getName(),
				seanceDtoFactory
					.createListSeanceDto(hall.getSeances())
				);
	}
	
	public List<HallDto> creatListHallDto(List<HallEntity> halls){
		return halls
				.stream()
				.map(this::createHallDto)
				.collect(Collectors.toList());
	}

	
	
}
