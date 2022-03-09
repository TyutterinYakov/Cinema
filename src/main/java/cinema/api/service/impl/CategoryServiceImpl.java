package cinema.api.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.api.dto.CategoryDto;
import cinema.api.dto.factory.CategoryDtoFactory;
import cinema.api.exception.BadRequestException;
import cinema.api.exception.NotFoundException;
import cinema.api.service.CategoryService;
import cinema.store.entity.CategoryEntity;
import cinema.store.entity.CinemaEntity;
import cinema.store.repository.CategoryRepository;
import cinema.store.repository.CinemaRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	private final CategoryRepository categoryDao;
	private final CinemaRepository cinemaDao;
	private final CategoryDtoFactory categoryDtoFactory;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryDao, CinemaRepository cinemaDao,
			CategoryDtoFactory categoryDtoFactory) {
		super();
		this.categoryDao = categoryDao;
		this.cinemaDao = cinemaDao;
		this.categoryDtoFactory = categoryDtoFactory;
	}

	@Override
	public List<CategoryDto> getCategoriesByCinema(Long cinemaId) {
		return categoryDtoFactory
				.createListCategoryDto(
						findCinemaById(cinemaId)
						.getCategories());
	}

	@Override
	public CategoryDto createNewCategory(Long cinemaId, String nameCategory) {
		CinemaEntity cinema = findCinemaById(cinemaId);
		findCategoryByCinemaAndNameIsPresentThrow(cinema, nameCategory.strip());
		return categoryDtoFactory
				.createCategoryDto(
						categoryDao.saveAndFlush(
								new CategoryEntity(
										nameCategory, 
										cinema)));
	}

	@Override
	@Transactional
	public CategoryDto updateCategory(Long categoryId, String categoryName) {
		CategoryEntity category = findCategoryById(categoryId);
		if(!category.getName().equalsIgnoreCase(categoryName.strip())) {
			findCategoryByCinemaAndNameIsPresentThrow(category.getCinema(), categoryName);
			category.setName(categoryName);
		}
		return categoryDtoFactory.createCategoryDto(category);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		categoryDao.deleteById(
				findCategoryById(categoryId).getCategoryId());
	}
	
	
	private CinemaEntity findCinemaById(Long cinemaId) {
		return cinemaDao.findById(cinemaId).orElseThrow(()->
				new NotFoundException(
						String.format(
								"Кинотеатр с идентификатором \"%s\" не найден", 
								cinemaId)));
	}
	
	private boolean findCategoryByCinemaAndNameIsPresentThrow(CinemaEntity cinema, String name) {
		categoryDao.findByCinemaAndNameIgnoreCase(cinema, name).ifPresent((c)->{
			throw new BadRequestException(String.format("Категория с именем \"%s\"  уже существует"));
		});
		return false;
	}
	
	private CategoryEntity findCategoryById(Long categoryId) {
		return categoryDao.findById(categoryId).orElseThrow(()->
				new NotFoundException(
						String.format(
								"Категория с идентификатором \"%s\" не найдена", 
								categoryId)));
	}

}
