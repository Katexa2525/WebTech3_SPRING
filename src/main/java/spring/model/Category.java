package spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import spring.data.service.StringQueryService.CategoryQuery;

//Класс модели для сохранения инфы по категориям фильмов

@Entity
@NamedQueries({
	@NamedQuery(name = "findCategoryByName", query = CategoryQuery.FIND_CATEGORY_BY_NAME_QUERY),
	@NamedQuery(name = "findCategoryByID", query = CategoryQuery.FIND_CATEGORY_BY_ID_QUERY),
	})
public class Category {
	
	@Id
	@GeneratedValue
	private int categoryId;
	private String name;
	
	public Category() {
		super();
	}
	
	// конструктор класса с двумя параметрами
	public Category(int categoryId, String name) {
		this();
		this.categoryId = categoryId;
		this.name = name;
	}
	
	// конструктор класса с одним параметров
	public Category(String name) {
		this();
		this.name = name;
	}
	
	// Свойства
	
		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


}
