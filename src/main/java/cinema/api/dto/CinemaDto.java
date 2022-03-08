package cinema.api.dto;


public class CinemaDto {
	
	private Long cinemaId;
	private String name;
	private String description;
	private String city;
	private String street;
	private String structure;
	private String frame;
	
	
	public CinemaDto() {
		super();
	}
	public CinemaDto(Long cinemaId, String name, String description, String city, String street, String structure,
			String frame) {
		super();
		this.cinemaId = cinemaId;
		this.name = name;
		this.description = description;
		this.city = city;
		this.street = street;
		this.structure = structure;
		this.frame = frame;
	}
	public Long getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
