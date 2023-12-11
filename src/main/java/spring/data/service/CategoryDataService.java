package spring.data.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import spring.data.service.StringQueryService.CategoryQuery;
import spring.data.service.contract.ICategoryDataService;
import spring.model.Actor;
import spring.model.Category;

public class CategoryDataService implements ICategoryDataService  {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Category getCategoryByName(String name) {
		TypedQuery<Category> query = entityManager.createNamedQuery("findCategoryByName", Category.class);
		query.setParameter("p_name", name);
		List<Category> categoryes = query.getResultList();
		return categoryes != null && !categoryes.isEmpty() ? categoryes.get(0) : null;
	}

	@Override
	public Category create(Category category) {
		entityManager.persist(category);
		return category;
	}

	@Override
	public Category update(Category category) {
		return entityManager.merge(category);
	}

	@Override
	public void remove(Category category) {
		entityManager.createNativeQuery(CategoryQuery.DELETE_CATEGORY_QUERY + category.getCategoryId()).executeUpdate();
		Category cat = entityManager.find(Category.class, category.getCategoryId());
		entityManager.remove(cat);
	}

	@Override
	public List<Category> getAllCategories() {
		TypedQuery<Category> query = entityManager.createNamedQuery(CategoryQuery.SELECT_CATEGORY_QUERY, Category.class);
		List<Category> categories = query.getResultList();
		return categories != null && !categories.isEmpty() ? categories : null;
	}

	@Override
	public Category getCategoryById(long categoryId) {
		TypedQuery<Category> query = entityManager.createNamedQuery("findCategoryByID", Category.class);
		query.setParameter("p_categoryid", categoryId);
		List<Category> category = query.getResultList();
		return category != null && !category.isEmpty() ? category.get(0) : null;
	}

}
