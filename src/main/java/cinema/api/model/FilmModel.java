package cinema.api.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FilmModel {
	@Size(min = 1, max = 100)
	private String title;
	@Size(min = 5, max = 3000)
	private String descrition;
	private String image;
	@Size(min = 5, max = 200)
	private String director;
	@NotNull
	private double duration;
	@NotNull
	private Long[] categories;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public Long[] getCategories() {
		return categories;
	}
	public void setCategories(Long[] categories) {
		this.categories = categories;
	}
	
	
	
	
	
}
