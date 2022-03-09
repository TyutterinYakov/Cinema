package cinema.api.dto;

import java.util.List;

public class HallDto {

	
	private Long hallId;
	private String name;
	private List<SeanceDto> seances;
	
	public HallDto() {
		super();
	}
	
	public HallDto(Long hallId, String name, List<SeanceDto> seances) {
		super();
		this.hallId = hallId;
		this.name = name;
		this.seances = seances;
	}

	public Long getHallId() {
		return hallId;
	}
	public void setHallId(Long hallId) {
		this.hallId = hallId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<SeanceDto> getSeances() {
		return seances;
	}

	public void setSeances(List<SeanceDto> seances) {
		this.seances = seances;
	}
	
	
	
	
	
	
}
