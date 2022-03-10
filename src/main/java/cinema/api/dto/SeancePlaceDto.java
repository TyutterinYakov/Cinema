package cinema.api.dto;

public class SeancePlaceDto {

	private Long id;
	private boolean reserved;
	private int number;
	
	
	public SeancePlaceDto() {
		super();
	}
	public SeancePlaceDto(Long id, boolean reserved, int number) {
		super();
		this.id = id;
		this.reserved = reserved;
		this.number=number;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
	
}
