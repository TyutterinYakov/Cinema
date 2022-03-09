package cinema.api.service;

import java.util.List;


import cinema.api.dto.FilmDto;
import cinema.api.model.FilmModel;

public interface FilmService {

	List<FilmDto> getFilmsByCategory(Long categoryId);
	FilmDto addFilmInTheCategories(FilmModel model);
	FilmDto updateFilm(FilmModel model, Long filmId);
	void deleteFilm(Long filmId);

}
