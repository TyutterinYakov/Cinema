package cinema.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.api.dto.SeancePlaceDto;
import cinema.api.dto.factory.SeancePlaceDtoFactory;
import cinema.api.exception.NotFoundException;
import cinema.api.service.SeancePlaceService;
import cinema.store.entity.SeanceEntity;
import cinema.store.repository.SeancePlaceRepository;
import cinema.store.repository.SeanceRepository;

@Service
public class SeancePlaceServiceImpl implements SeancePlaceService {

	private final SeancePlaceRepository seancePlaceDao;
	private final SeancePlaceDtoFactory seancePlaceDtoFactory;
	private final SeanceRepository seanceDao;
	
	@Autowired
	public SeancePlaceServiceImpl(SeancePlaceRepository seancePlaceDao, SeancePlaceDtoFactory seancePlaceDtoFactory,
			SeanceRepository seanceDao) {
		super();
		this.seancePlaceDao = seancePlaceDao;
		this.seancePlaceDtoFactory = seancePlaceDtoFactory;
		this.seanceDao = seanceDao;
	}

	@Override
	public List<SeancePlaceDto> getSeancePlacesBySeance(Long seanceId) {
		return seancePlaceDtoFactory
				.createListSeancePlaceDto(
						findSeanceById(seanceId)
						.getSeancePlaces()
						.stream()
						.sorted((o1, o2)->o1.getPlace().getNumber()-o2.getPlace().getNumber())
						.collect(Collectors.toList()));
	}
	
	
	private SeanceEntity findSeanceById(Long seanceId) {
		return seanceDao.findById(seanceId).orElseThrow(()->
				new NotFoundException(String.format("Сеанс с идентификатором \"%s\" не найден", seanceId)));
	}
	
	
	
}
