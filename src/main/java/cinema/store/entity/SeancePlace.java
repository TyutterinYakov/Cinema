package cinema.store.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SeancePlace {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private SeanceEntity seance;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private PlaceEntity place;
	private boolean reserved = false;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private ClientEntity client;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SeanceEntity getSeance() {
		return seance;
	}
	public void setSeance(SeanceEntity seance) {
		this.seance = seance;
	}
	public PlaceEntity getPlace() {
		return place;
	}
	public void setPlace(PlaceEntity place) {
		this.place = place;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	
	
	
	
}
