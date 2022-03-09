package cinema.api.service;

import java.util.List;


import cinema.api.dto.HallDto;
import cinema.api.model.HallModel;

public interface HallService {

	List<HallDto> getHallsByCinema(Long cinemaId);

	HallDto createNewHall(Long cinemaId, HallModel hall);

	HallDto updateHall(Long hallId, HallModel hall);

	void deleteHall(Long hallId);

}
