package cinema.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cinema.api.dto.SeancePlaceDto;
import cinema.api.service.SeancePlaceService;

@RestController
@CrossOrigin("*")
public class SeancePlaceController {

	private final SeancePlaceService seancePlaceService;

	public SeancePlaceController(SeancePlaceService seancePlaceService) {
		super();
		this.seancePlaceService = seancePlaceService;
	}
	
	public static final String GET_SEANCE_PLACES_BY_SEANCE = "/api/cities/cinemas/halls/seances/{seanceId}";
	
	
	
	@GetMapping(GET_SEANCE_PLACES_BY_SEANCE)
	public ResponseEntity<List<SeancePlaceDto>> getSeancePlacesBySeance(
			@PathVariable("seanceId") Long seanceId){
		return ResponseEntity.ok(seancePlaceService.getSeancePlacesBySeance(seanceId));
	}
}
