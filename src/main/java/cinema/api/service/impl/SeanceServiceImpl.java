package cinema.api.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cinema.api.dto.SeanceDto;
import cinema.api.dto.factory.SeanceDtoFactory;
import cinema.api.exception.NotFoundException;
import cinema.api.model.SeanceModel;
import cinema.api.service.SeanceService;
import cinema.store.entity.FilmEntity;
import cinema.store.entity.HallEntity;
import cinema.store.entity.SeanceEntity;
import cinema.store.repository.FilmRepository;
import cinema.store.repository.HallRepository;
import cinema.store.repository.SeanceRepository;

@Service
public class SeanceServiceImpl implements SeanceService {

	private final SeanceDtoFactory seanceDtoFactory;
	private final SeanceRepository seanceDao;
	private final FilmRepository filmDao;
	private final HallRepository hallDao;
	
	public SeanceServiceImpl(SeanceDtoFactory seanceDtoFactory, SeanceRepository seanceDao, FilmRepository filmDao,
			HallRepository hallDao) {
		super();
		this.seanceDtoFactory = seanceDtoFactory;
		this.seanceDao = seanceDao;
		this.filmDao = filmDao;
		this.hallDao = hallDao;
	}

	@Override
	public SeanceDto createSeanceInTheHall(SeanceModel model, Long hallId) { //TODO проверка по времени проведения
		FilmEntity film = findFilmById(model.getFilmId());
		HallEntity hall = findHallById(hallId);
		return seanceDtoFactory
				.createSeanceDto(
						seanceDao.saveAndFlush(
							new SeanceEntity(
									model.getStartedAt(), 
									model.getStartedAt()
										.plusMinutes(Math.round(
												film.getDuration()*60)),  
									hall, 
									film,
									model.getPrice())));
	}

	@Override
	public SeanceDto updateSeance(Long seanceId, SeanceModel model) { //TODO проверка по времени проведения
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSeance(Long seanceId) {
		seanceDao.deleteById(findSeanceById(seanceId).getSeanceId());
	}
	
	
	private SeanceEntity findSeanceById(Long seanceId) {
		return seanceDao.findById(seanceId).orElseThrow(()->
				new NotFoundException(
						String.format(
								"Сеанс с идентификатором \"%s\" не найден", 
								seanceId)));
	}
	
	private FilmEntity findFilmById(Long filmId) {
		return filmDao.findById(filmId).orElseThrow(()->
				new NotFoundException(
						String.format(
								"Фильм с идентификатором \"%s\" не найден", 
								 filmId)));
	}
	
	private HallEntity findHallById(Long hallId) {
		return hallDao.findById(hallId).orElseThrow(()->
				new NotFoundException(
						String.format(
								"Холл с идентификатором \"%s\" не найден", 
								 hallId)));
	}

}
