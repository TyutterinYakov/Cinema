package cinema.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.api.dto.SeanceDto;
import cinema.api.exception.BadRequestException;
import cinema.api.model.SeanceModel;
import cinema.api.service.SeanceService;

@RestController
@CrossOrigin("*")
public class SeanceController {

	private final SeanceService seanceService;

	@Autowired
	public SeanceController(SeanceService seanceService) {
		super();
		this.seanceService = seanceService;
	}
	
	public final String ADD_SEANCE_IN_THE_HALL = "/api/cities/cinemas/halls/{hallId}/seances";
	public final String UPDATE_SEANCE = "/api/cities/cinemas/halls/seances/{seanceId}";
	public final String DELETE_SEANCE = "/api/cities/cinemas/halls/seances/{seanceId}";
	
	
	@PostMapping(ADD_SEANCE_IN_THE_HALL)
	public ResponseEntity<SeanceDto> createSeanceInTheHall(
			@PathVariable("hallId") Long hallId, @Valid @RequestBody  SeanceModel model, BindingResult result){
		checkError(result);
		return new ResponseEntity<>(
				seanceService.createSeanceInTheHall(model, hallId), 
				HttpStatus.CREATED);
	}
	
	@PutMapping(UPDATE_SEANCE)
	public ResponseEntity<SeanceDto> updateSeance(
			@PathVariable("seanceId") Long seanceId, @Valid @RequestBody SeanceModel model, BindingResult result){
		checkError(result);
		return new ResponseEntity<>(seanceService.updateSeance(seanceId, model), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(DELETE_SEANCE)
	public ResponseEntity<?> deleteSeance(@PathVariable("seanceId") Long seanceId){
		seanceService.deleteSeance(seanceId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	private boolean checkError(BindingResult result) {
		if(result.hasErrors()) {
			throw new BadRequestException(
					String.format(
							"Ошибка при вводе параметров сеанса %s", 
							result.getAllErrors()));
		}
		return false;
	}
	
	
	
	
	
	
}
