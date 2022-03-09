package cinema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.api.dto.CategoryDto;
import cinema.api.service.CategoryService;

@RestController
@CrossOrigin("*")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	public static final String GET_CATEGORIES_BY_CINEMA = "/api/cities/cinemas/{cinemaId}/categories";
	public static final String ADD_CATEGORY_IN_THE_CINEMA = "/api/cities/cinemas/{cinemaId}/categories";
	public static final String UPDATE_CATEGORY = "/api/cities/cinemas/categories/{categoryId}";
	public static final String DELETE_CATEGORY = "/api/cities/cinemas/categories/{categoryId}";
	
	
	@GetMapping(GET_CATEGORIES_BY_CINEMA)
	public ResponseEntity<List<CategoryDto>> getCategoriesByCinema(
			@PathVariable("cinemaId") Long cinemaId){
		return ResponseEntity.ok(
				categoryService
				.getCategoriesByCinema(cinemaId));
	}
	
	@PostMapping(ADD_CATEGORY_IN_THE_CINEMA)
	public ResponseEntity<CategoryDto> addCategoryInTheCinema(
			@PathVariable("cinemaId") Long cinemaId, @RequestParam String nameCategory){
		return new ResponseEntity<>(
				categoryService.createNewCategory(cinemaId, nameCategory), 
				HttpStatus.CREATED);
	}
	
	@PutMapping(UPDATE_CATEGORY )
	public ResponseEntity<CategoryDto> updateCategory(
			@PathVariable("categoryId") Long categoryId, @RequestParam String categoryName){
		return new ResponseEntity<>(
				categoryService.updateCategory(categoryId, categoryName), 
				HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(DELETE_CATEGORY)
	public ResponseEntity<?> deleteCategory(
			@PathVariable("categoryId") Long categoryId){
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
}
