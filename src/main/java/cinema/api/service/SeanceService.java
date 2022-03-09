package cinema.api.service;


import cinema.api.dto.SeanceDto;
import cinema.api.model.SeanceModel;

public interface SeanceService {

	SeanceDto createSeanceInTheHall(SeanceModel model, Long hallId);

	SeanceDto updateSeance(Long seanceId, SeanceModel model);

	void deleteSeance(Long seanceId);

}
