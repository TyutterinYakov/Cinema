package cinema.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.api.dto.FilmDto;
import cinema.api.dto.factory.FilmDtoFactory;
import cinema.api.exception.NotFoundException;
import cinema.api.model.FilmModel;
import cinema.api.service.FilmService;
import cinema.store.entity.CategoryEntity;
import cinema.store.entity.FilmCategory;
import cinema.store.entity.FilmEntity;
import cinema.store.repository.CategoryRepository;
import cinema.store.repository.FilmCategoryRepository;
import cinema.store.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	
	private final FilmRepository filmDao;
	private final FilmDtoFactory filmDtoFactory;
	private final CategoryRepository categoryDao;
	private final FilmCategoryRepository filmCategoryDao;
	
	@Autowired
	public FilmServiceImpl(FilmRepository filmDao, FilmDtoFactory filmDtoFactory, CategoryRepository categoryDao,
			FilmCategoryRepository filmCategoryDao) {
		super();
		this.filmDao = filmDao;
		this.filmDtoFactory = filmDtoFactory;
		this.categoryDao = categoryDao;
		this.filmCategoryDao = filmCategoryDao;
	}

	@Override
	public List<FilmDto> getFilmsByCategory(Long categoryId) {
		CategoryEntity category = findCategoryById(categoryId);
		return filmDtoFactory.createListFilmDto(
				filmCategoryDao
				.findAllByCategory(category)
				.stream()
				.map(FilmCategory::getFilm)
				.collect(Collectors.toList()));
	}

	@Override
	public FilmDto addFilmInTheCategories(FilmModel model) {
		FilmEntity film = filmDao.saveAndFlush(new FilmEntity(
										model.getTitle(), 
										model.getDescrition(), 
										model.getImage(), 
										model.getDirector(), 
										model.getDuration()));
		saveCategory(model, film);
		return filmDtoFactory.createFilmDto(film);
	}

	@Override
	@Transactional
	public FilmDto updateFilm(FilmModel model, Long filmId) {
		FilmEntity film = findFilmById(filmId);
		film.getFilmCategory().clear();
		film.setDescrition(model.getDescrition());
		film.setDirector(model.getDirector());
		film.setDuration(model.getDuration());
		saveCategory(model, film);
		return filmDtoFactory.createFilmDto(film);
	}

	@Override
	public void deleteFilm(Long filmId) {
		filmDao.deleteById(findFilmById(filmId).getFilmId());
	}
	
	
	
	private CategoryEntity findCategoryById(Long categoryId) {
		return categoryDao.findById(categoryId).orElseThrow(()->
				new NotFoundException(
						String.format(
								"Категория с идентификатором \"%s\" не найдена", 
								categoryId)));
	}
	
	private FilmEntity findFilmById(Long filmId) {
		return filmDao.findById(filmId).orElseThrow(()->
				new NotFoundException(
						String.format("Фильм с идентификатором \"%s\" не найден", filmId)));
	}
	
	private void saveCategory(FilmModel model, FilmEntity film) {
		model.getCategories().stream().forEach((c)->{
			CategoryEntity category = findCategoryById(c);
			filmCategoryDao.save(new FilmCategory(film, category));
			}
		);
	}
	
	
	
}
