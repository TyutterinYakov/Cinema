package cinema.api.service;

import java.util.List;

import cinema.api.dto.CityDto;

public interface CityService {
	public List<CityDto> getListCity();
	public CityDto getCity(Long cityId);
	public CityDto createCity(String name);
	public void deleteCity(Long cityId);
	public CityDto updateCity(Long cityId, String name);
}
