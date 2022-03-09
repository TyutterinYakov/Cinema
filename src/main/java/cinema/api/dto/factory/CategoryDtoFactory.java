package cinema.api.dto.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cinema.api.dto.CategoryDto;
import cinema.store.entity.CategoryEntity;

@Component
public class CategoryDtoFactory {

	
	public CategoryDto createCategoryDto(CategoryEntity entity) {
		return new CategoryDto(
				entity.getCategoryId(), 
				entity.getName());
	}
	
	public List<CategoryDto> createListCategoryDto(List<CategoryEntity> entities){
		return entities
				.stream()
				.map(this::createCategoryDto)
				.collect(Collectors.toList());
	}
}
