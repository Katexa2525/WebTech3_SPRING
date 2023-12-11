package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.data.service.CategoryDataService;
import spring.model.Category;
import spring.service.contract.ICategoryService;

//Сервис для проброски данных жанров фильмов на контроллеры
@Service
@Transactional
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryDataService categoryDataService;

	@Transactional(readOnly = true)
	public Category getCategoryByName(String name) {
		return categoryDataService.getCategoryByName(name);
	}
	
	@Transactional(readOnly = true)
	public Category getCategoryById(long categoryId) {
		return categoryDataService.getCategoryById(categoryId);
	}

	public Category create(Category category) {
		return categoryDataService.create(category);
	}

	public Category update(Category category) {
		return categoryDataService.update(category);
	}

	public void remove(Category category) {
		categoryDataService.remove(category);
	}

	public List<Category> getAllCategories() {
		return categoryDataService.getAllCategories();
	}

}
