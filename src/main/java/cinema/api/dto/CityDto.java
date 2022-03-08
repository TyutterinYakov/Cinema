package cinema.api.dto;


public class CityDto {
	private Long cityId;
	private String name;
	
	
	
	public CityDto() {
		super();
	}
	public CityDto(Long cityId, String name) {
		super();
		this.cityId = cityId;
		this.name = name;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
