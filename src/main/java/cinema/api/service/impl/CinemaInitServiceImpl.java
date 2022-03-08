package cinema.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.api.service.CinemaInitService;
import cinema.store.entity.CinemaEntity;
import cinema.store.entity.CityEntity;
import cinema.store.repository.CinemaRepository;
import cinema.store.repository.CityRepository;

@Service
public class CinemaInitServiceImpl implements CinemaInitService{

	
	private final CityRepository cityDao;
	private final CinemaRepository cinemaDao;
	
	
	

	
	

	public CinemaInitServiceImpl(CityRepository cityDao, CinemaRepository cinemaDao) {
		super();
		this.cityDao = cityDao;
		this.cinemaDao = cinemaDao;
	}




	@Override
	public void initCities() {
		List<CityEntity> cities = List.of(
				new CityEntity("Санкт-Петербург"), 
				new CityEntity("Москва"), 
				new CityEntity("Краснодар"), 
				new CityEntity("Калининград"));
		cities.stream().forEach(cityDao::save);
	}




	@Override
	public void initCinema() {
//		cityDao.findAll().forEach((c)->{
//				List.of("KINOSTAR", "FIVESTAR", "GLOBUS").forEach((n)->{
//					cinemaDao.save(new CinemaEntity(n, c));
//				}
//			);
//		}
//		);
	}


	@Override
	public void initCategory() {
		
	}
	
	


	

	

}
