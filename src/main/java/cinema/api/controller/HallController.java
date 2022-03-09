package cinema.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.api.dto.HallDto;
import cinema.api.exception.BadRequestException;
import cinema.api.model.HallModel;
import cinema.api.service.HallService;

@RestController
@CrossOrigin("*")
public class HallController {

	
	private final HallService hallService;

	@Autowired
	public HallController(HallService hallService) {
		super();
		this.hallService = hallService;
	}
	
	public static final String GET_HALLS_BY_CINEMA = "/api/cities/cinemas/{cinemaId}/halls";
	public static final String ADD_HALL_IN_THE_CINEMA = "/api/cities/cinemas/{cinemaId}/halls";
	public static final String UPDATE_HALL = "/api/cities/cinemas/halls/{hallId}";
	public static final String DELETE_HALL = "/api/cities/cinemas/halls/{hallId}";
	
	@GetMapping(GET_HALLS_BY_CINEMA)
	public ResponseEntity<List<HallDto>> getHallsByCinema(
			@PathVariable("cinemaId") Long cinemaId){
		return ResponseEntity.ok(hallService.getHallsByCinema(cinemaId));
	}
	
	@PostMapping(ADD_HALL_IN_THE_CINEMA)
	public ResponseEntity<HallDto> addHallInTheCinema(
			@PathVariable("cinemaId") Long cinemaId, @Valid HallModel hall, BindingResult result){
		checkError(result);
		return new ResponseEntity<>(hallService.createNewHall(cinemaId, hall),HttpStatus.CREATED);
	}
	
	@PutMapping(UPDATE_HALL)
	public ResponseEntity<HallDto> updateHall(
			@PathVariable("hallId") Long hallId, @Valid HallModel hall, BindingResult result){
		checkError(result);
		return new ResponseEntity<>(
				hallService.updateHall(hallId, hall),
				HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(DELETE_HALL)
	public ResponseEntity<?> deleteHall(@PathVariable("hallId") Long hallId){
		hallService.deleteHall(hallId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	
	private boolean checkError(BindingResult result) {
		if(result.hasErrors()) {
			throw new BadRequestException(String.format("Ошибка при вводе данных %s", result.getAllErrors()));
		}
		return false;
	}
	
	
	
	
}
