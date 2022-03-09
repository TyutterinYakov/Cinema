package cinema.api.dto;

public class CategoryDto {
	private Long categoryId;
	private String name;
	
	public CategoryDto() {
		super();
	}
	public CategoryDto(Long categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
