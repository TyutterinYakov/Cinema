package cinema.store.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class SeanceEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long seanceId;
	private LocalDateTime startedAt;
	private LocalDateTime stopedAt;
	@ManyToOne(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private FilmProject filmProject;
	
	
	
	
}
