package cinema.api.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.api.dto.CinemaDto;
import cinema.api.dto.factory.CinemaDtoFactory;
import cinema.api.exception.NotFoundException;
import cinema.api.model.CinemaModel;
import cinema.api.service.CinemaService;
import cinema.store.entity.CinemaEntity;
import cinema.store.entity.CityEntity;
import cinema.store.repository.CinemaRepository;
import cinema.store.repository.CityRepository;

@Service
public class CinemaServiceImpl implements CinemaService{

	private final CinemaRepository cinemaDao;
	private final CityRepository cityDao;
	private final CinemaDtoFactory cinemaDtoFactory;
	
	@Autowired
	public CinemaServiceImpl(CinemaRepository cinemaDao, CityRepository cityDao, CinemaDtoFactory cinemaDtoFactory) {
		super();
		this.cinemaDao = cinemaDao;
		this.cityDao = cityDao;
		this.cinemaDtoFactory = cinemaDtoFactory;
	}

	@Override
	public List<CinemaDto> getCinemasByCity(Long cityId) {
		return cinemaDtoFactory
				.createListCinemaDto(
						findCityById(cityId)
							.getCinemas());
	}

	@Override
	public CinemaDto addCinema(CinemaModel model, Long cityId) {
		return cinemaDtoFactory
				.createCinemaDto(
						cinemaDao.save(
								new CinemaEntity(
										model.getName(), 
										model.getDescription(), 
										findCityById(cityId),
										model.getStreet(), 
										model.getStructure(), 
										model.getFrame())));
	}

	@Override
	public void deleteCinema(Long cinemaId) {
		cinemaDao.deleteById(
				findCinemaById(cinemaId)
				.getCinemaId());
	}

	@Override
	@Transactional
	public CinemaDto updateCinemas(CinemaModel model, Long cinemaId) {
		CinemaEntity cinema = findCinemaById(cinemaId);
		cinema.setDescription(model.getDescription());
		cinema.setFrame(model.getFrame());
		cinema.setName(model.getName());
		cinema.setStreet(model.getName());
		cinema.setStructure(model.getStructure());
		return cinemaDtoFactory
				.createCinemaDto(cinema);
	}
	
	private CityEntity findCityById(Long cityId) {
		return cityDao.findById(cityId).orElseThrow(()->
				new NotFoundException(
						String.format("Город с идентификатором \"%s\" не найден", cityId)));
	}
	
	private CinemaEntity findCinemaById(Long cinemaId) {
		
		return cinemaDao.findById(cinemaId).orElseThrow(()->
				new NotFoundException(
						String.format(
								"Кинотеатр с идентификатором \"%s\" не найден", 
								cinemaId)));
	}

}
