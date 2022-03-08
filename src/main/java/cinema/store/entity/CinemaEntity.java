package cinema.store.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cinema")
public class CinemaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cinemaId;
	@Column(length = 100)
	private String name;
	private String description;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private CityEntity city;
	private String street;
	@Column(length=5)
	private String structure;
	@Column(length=4)
	private String frame;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="cinema")
	private List<CategoryEntity> categories = new ArrayList<>();
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy="cinema")
	private List<HallEntity> hall = new ArrayList<>();
	
	
	
	public CinemaEntity() {
		super();
	}
	
	
	public CinemaEntity(String name, String description, CityEntity city, String street, String structure,
			String frame) {
		super();
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
	public CityEntity getCity() {
		return city;
	}
	public void setCity(CityEntity city) {
		this.city = city;
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
	public List<CategoryEntity> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public List<HallEntity> getHall() {
		return hall;
	}
	public void setHall(List<HallEntity> hall) {
		this.hall = hall;
	}
	
	
	
	
	
	
	
	
	
	
}
