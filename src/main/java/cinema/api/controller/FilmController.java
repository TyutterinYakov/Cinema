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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.api.dto.FilmDto;
import cinema.api.exception.BadRequestException;
import cinema.api.model.FilmModel;
import cinema.api.service.FilmService;

@RestController
@CrossOrigin("*")
public class FilmController {

	private final FilmService filmService;

	@Autowired
	public FilmController(FilmService filmService) {
		super();
		this.filmService = filmService;
	}
	
	public static final String GET_FILMS_BY_CATEGORY = "/api/cities/cinemas/categories/{categoryId}/films";
	public static final String ADD_FILM_IN_THE_CATEGORIES = "/api/cities/cinemas/categories/films";
	public static final String UPDATE_FILM = "/api/cities/cinemas/categories/films/{filmId}";
	public static final String DELETE_FILM = "/api/cities/cinemas/categories/films/{filmId}";
	
	
	@GetMapping(GET_FILMS_BY_CATEGORY)
	public ResponseEntity<List<FilmDto>> getFilmsByCategory(@PathVariable("categoryId") Long categoryId){
		return ResponseEntity.ok(filmService.getFilmsByCategory(categoryId));
	}
	
	@PostMapping(ADD_FILM_IN_THE_CATEGORIES)
	public ResponseEntity<FilmDto> addFilmInTheCategory(
			@Valid @RequestBody FilmModel model, BindingResult result){
		checkError(result);
		return new ResponseEntity<>(
				filmService.addFilmInTheCategories(model), 
				HttpStatus.CREATED);
	}
	
	@PutMapping(UPDATE_FILM)
	public ResponseEntity<FilmDto> updateFilm(
			@PathVariable("filmId") Long filmId, @Valid @RequestBody FilmModel model, BindingResult result){
		checkError(result);
		return new ResponseEntity<>(filmService.updateFilm(model, filmId) ,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(DELETE_FILM)
	public ResponseEntity<?> deleteFilm(@PathVariable("filmId") Long filmId){
		filmService.deleteFilm(filmId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	private boolean checkError(BindingResult result) {
		if(result.hasErrors()) {
			throw new BadRequestException(
					String.format("Ошибка при вводе параметров фильма: %s", 
							result.getAllErrors()));
		}
		return false;
	}
	
	
}
