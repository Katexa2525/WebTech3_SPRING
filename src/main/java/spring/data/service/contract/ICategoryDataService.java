package spring.data.service.contract;

import java.util.List;

import spring.model.Category;

public interface ICategoryDataService {
	
	Category getCategoryByName(final String name);

	Category getCategoryById(long categoryId);
	
	Category create(final Category category);
	
	Category update(Category category);

	void remove(final Category category);
	
	List<Category> getAllCategories();
}
