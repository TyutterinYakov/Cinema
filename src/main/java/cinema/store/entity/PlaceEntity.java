package cinema.store.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="place")
public class PlaceEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long placeId;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private HallEntity hall;
	private int number;
	
	
	
	public PlaceEntity() {
		super();
	}
	public PlaceEntity(HallEntity hall, int number) {
		super();
		this.hall = hall;
		this.number = number;
	}
	public Long getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}
	public HallEntity getHall() {
		return hall;
	}
	public void setHall(HallEntity hall) {
		this.hall = hall;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	
	
}
