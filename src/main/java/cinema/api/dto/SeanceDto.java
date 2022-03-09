package cinema.api.dto;

import java.time.LocalDateTime;

public class SeanceDto {

	private Long seanceId;
	private LocalDateTime startedAt;
	private LocalDateTime stopedAt;
	
	public SeanceDto() {
		super();
	}
	public SeanceDto(Long seanceId, LocalDateTime startedAt, LocalDateTime stopedAt) {
		super();
		this.seanceId = seanceId;
		this.startedAt = startedAt;
		this.stopedAt = stopedAt;
	}
	public Long getSeanceId() {
		return seanceId;
	}
	public void setSeanceId(Long seanceId) {
		this.seanceId = seanceId;
	}
	public LocalDateTime getStartedAt() {
		return startedAt;
	}
	public void setStartedAt(LocalDateTime startedAt) {
		this.startedAt = startedAt;
	}
	public LocalDateTime getStopedAt() {
		return stopedAt;
	}
	public void setStopedAt(LocalDateTime stopedAt) {
		this.stopedAt = stopedAt;
	}
	
	
	
	
}
