package cinema.api.service;

import java.util.List;

import cinema.api.dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> getCategoriesByCinema(Long cinemaId);

	CategoryDto createNewCategory(Long cinemaId, String nameCategory);

	CategoryDto updateCategory(Long categoryId, String categoryName);

	void deleteCategory(Long categoryId);

}
