package cinema.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HallModel {

	@Size(min=2, max=10)
	private String name;
	@NotNull
	private Integer countPlace;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCountPlace() {
		return countPlace;
	}
	public void setCountPlace(Integer countPlace) {
		this.countPlace = countPlace;
	}
	
	
}
