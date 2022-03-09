package cinema.api.service;

import java.util.List;

import cinema.api.dto.CinemaDto;
import cinema.api.model.CinemaModel;

public interface CinemaService {

	public List<CinemaDto> getCinemasByCity(Long cityId);
	public CinemaDto addCinema(CinemaModel model, Long cityId);
	public void deleteCinema(Long cinemaId);
	public CinemaDto updateCinemas(CinemaModel model, Long cinemaId);


}
