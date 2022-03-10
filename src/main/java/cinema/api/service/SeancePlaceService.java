package cinema.api.service;

import java.util.List;

import cinema.api.dto.SeancePlaceDto;

public interface SeancePlaceService {

	List<SeancePlaceDto> getSeancePlacesBySeance(Long seanceId);

}
