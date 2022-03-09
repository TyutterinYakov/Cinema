package cinema.api.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.api.dto.HallDto;
import cinema.api.dto.factory.HallDtoFactory;
import cinema.api.exception.BadRequestException;
import cinema.api.exception.NotFoundException;
import cinema.api.model.HallModel;
import cinema.api.service.HallService;
import cinema.store.entity.CinemaEntity;
import cinema.store.entity.HallEntity;
import cinema.store.repository.CinemaRepository;
import cinema.store.repository.HallRepository;

@Service
public class HallServiceImpl implements HallService{

	private final HallRepository hallDao;
	private final CinemaRepository cinemaDao;
	private final HallDtoFactory hallDtoFactory;
	
	@Autowired
	public HallServiceImpl(HallRepository hallDao, CinemaRepository cinemaDao, HallDtoFactory hallDtoFactory) {
		super();
		this.hallDao = hallDao;
		this.cinemaDao = cinemaDao;
		this.hallDtoFactory = hallDtoFactory;
	}

	@Override
	public List<HallDto> getHallsByCinema(Long cinemaId) {
		return hallDtoFactory.creatListHallDto(
				findCinemaById(cinemaId).getHall());
	}

	@Override
	public HallDto createNewHall(Long cinemaId, HallModel hall) {
		CinemaEntity cinema = findCinemaById(cinemaId);
		findHallByCinemaAndNameIsPresentThrow(cinema, hall.getName());
		return hallDtoFactory.createHallDto(
				hallDao.saveAndFlush(
						new HallEntity(
								hall.getName(), 
								hall.getCountPlace(), 
								cinema)));
		
	}

	@Override
	@Transactional
	public HallDto updateHall(Long hallId, HallModel model) {
		HallEntity hall = hallDao.findById(hallId).orElseThrow(()->
				new NotFoundException(
						String.format("Холл с идентификатором \"%s\" не найден", hallId)));
		hall.setCountPlace(model.getCountPlace());
		if(!model.getName().equalsIgnoreCase(hall.getName())) {
			if(!findHallByCinemaAndNameIsPresentThrow(hall.getCinema(), model.getName())) {
				hall.setName(model.getName());
			}
		}
		return null;
	}

	@Override
	public void deleteHall(Long hallId) {
		hallDao.findById(hallId).ifPresentOrElse((h)->{
			hallDao.deleteById(h.getHallId());
		}, ()->{
			throw new NotFoundException(
					String.format("Холл с идентификатором \"%s\" не найден", hallId));
		});
	}
	
	private CinemaEntity findCinemaById(Long cinemaId) {
		return cinemaDao.findById(cinemaId).orElseThrow(()->
				new NotFoundException(
						String.format(
								"Кинотеатр с идентификатором \"%s\" не найден", 
								cinemaId)));
	}
	
	private boolean findHallByCinemaAndNameIsPresentThrow(CinemaEntity cinema, String name) {
		hallDao.findByCinemaAndNameIgnoreCase(cinema, name).ifPresent((h)->{
			throw new BadRequestException(
					String.format("Холл с именем \"%s\" уже есть в этом кинотеатре")); 
		});
		return false;
	}

}
