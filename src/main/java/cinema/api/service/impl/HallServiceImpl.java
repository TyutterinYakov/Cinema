package cinema.api.service.impl;

import java.util.ArrayList;
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
import cinema.store.entity.PlaceEntity;
import cinema.store.repository.CinemaRepository;
import cinema.store.repository.HallRepository;
import cinema.store.repository.PlaceRepository;

@Service
public class HallServiceImpl implements HallService{

	private final HallRepository hallDao;
	private final CinemaRepository cinemaDao;
	private final HallDtoFactory hallDtoFactory;
	private final PlaceRepository placeDao;
	
	@Autowired
	public HallServiceImpl(HallRepository hallDao, CinemaRepository cinemaDao, HallDtoFactory hallDtoFactory,
			PlaceRepository placeDao) {
		super();
		this.hallDao = hallDao;
		this.cinemaDao = cinemaDao;
		this.hallDtoFactory = hallDtoFactory;
		this.placeDao = placeDao;
	}

	@Override
	public List<HallDto> getHallsByCinema(Long cinemaId) {
		return hallDtoFactory.creatListHallDto(
				findCinemaById(cinemaId).getHall());
	}

	@Override
	@Transactional
	public HallDto createNewHall(Long cinemaId, HallModel model) {
		CinemaEntity cinema = findCinemaById(cinemaId);
		findHallByCinemaAndNameIsPresentThrow(cinema, model.getName());
		HallEntity hall = hallDao.saveAndFlush(
				new HallEntity(
						model.getName(), 
						model.getCountPlace(), 
						cinema));
		generatePlaceByHall(hall);
		return hallDtoFactory.createHallDto(hall);
	}

	@Override
	@Transactional
	public HallDto updateHall(Long hallId, HallModel model) {
		HallEntity hall = hallDao.findById(hallId).orElseThrow(()->
				new NotFoundException(
						String.format("Холл с идентификатором \"%s\" не найден", hallId)));
		if(hall.getCountPlace()!=model.getCountPlace()) {
			hall.setCountPlace(model.getCountPlace());
			generatePlaceByHall(hall);
		}
		if(!model.getName().equalsIgnoreCase(hall.getName())) {
			if(!findHallByCinemaAndNameIsPresentThrow(hall.getCinema(), model.getName())) {
				hall.setName(model.getName());
			}
		}
		return hallDtoFactory.createHallDto(hall);
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
					String.format("Холл с именем \"%s\" уже есть в этом кинотеатре", name)); 
		});
		return false;
	}
	
	private void generatePlaceByHall(HallEntity hall){
		for(int i=1; i<=hall.getCountPlace(); i++) {
			placeDao.save(new PlaceEntity(hall, i));
		}
	}

}
