package cinema.api.model;

import javax.validation.constraints.Size;

public class CinemaModel {

	@Size(min = 3, max = 50)
	private String name;
	@Size(min = 10, max = 3000)
	private String description;
	@Size(min = 3, max = 100)
	private String street;
	@Size(min = 1, max = 5)
	private String structure;
	@Size(max = 4)
	private String frame;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getFrame() {
		return frame;
	}
	public void setFrame(String frame) {
		this.frame = frame;
	}
	
	
	
	
}
