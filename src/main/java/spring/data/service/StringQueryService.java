package spring.data.service;

public class StringQueryService {

	public static class UserQuery {
		
		public static final String INSERT_CUSTOMER_QUERY = "INSERT INTO customer(first_name, last_name, email, address, active, discount, bonus, is_admin, password) "
														 + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		public static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customer WHERE customer_id=";
		public static final String UPDATE_CUSTOMER_QUERY = "UPDATE customer SET first_name=?, last_name=?, email=?, address=?, active=?, discount=?, bonus=?,"
														 + " is_admin=?, password=?"
														 + " WHERE customer_id=?";
		public static final String SELECT_CUSTOMER_BY_ID_QUERY = "SELECT * FROM customer WHERE customer_id=?";
		public static final String SELECT_CUSTOMER_QUERY = "SELECT * FROM customer";
		public static final String SELECT_CUSTOMER_MOVIES_QUERY = "SELECT * FROM v_movie_customer WHERE customer_id=?";
		
		public static final String FIND_USER_BY_EMAIL_QUERY = "SELECT * FROM customer WHERE email = :p_email";
		public static final String FIND_USER_BY_LOGIN_QUERY = "SELECT * FROM customer WHERE first_name = :p_login";
		public static final String FIND_USER_BY_ID_QUERY = "SELECT * FROM customer WHERE customer_id = :p_customerid";
		public static final String FIND_USER_BY_LOGIN_PASSWORD_QUERY = "SELECT * FROM customer WHERE first_name = :p_login AND password = :p_password";
	}
	
	public static class ActorQuery {
		public static final String INSERT_ACTOR_QUERY = "INSERT INTO actor(first_name, last_name) VALUES(?, ?)";
		public static final String DELETE_ACTOR_QUERY = "DELETE FROM actor WHERE actor_id=";
		public static final String UPDATE_ACTOR_QUERY = "UPDATE actor SET first_name=?, last_name=? WHERE actor_id=?";
		public static final String SELECT_ACTOR_BY_ID_QUERY = "SELECT * FROM actor WHERE actor_id=?";
		public static final String SELECT_ACTOR_QUERY = "SELECT * FROM actor";
		public static final String FIND_ACTOR_BY_FIRSTNAME_QUERY = "SELECT * FROM actor WHERE first_name = :p_name";
		public static final String FIND_ACTOR_BY_SECONDNAME_QUERY = "SELECT * FROM actor WHERE second_name = :p_name";
		public static final String FIND_ACTOR_BY_ID_QUERY = "SELECT * FROM actor WHERE actor_id = :p_actorid";
	}
	
	public static class CategoryQuery {
		public static final String INSERT_CATEGORY_QUERY = "INSERT INTO category(name) VALUES(?)";
		public static final String DELETE_CATEGORY_QUERY = "DELETE FROM category WHERE category_id=";
		public static final String UPDATE_CATEGORY_QUERY = "UPDATE category SET name=? WHERE category_id=?";
		public static final String SELECT_CATEGORY_BY_ID_QUERY = "SELECT * FROM category WHERE category_id=?";
		public static final String FIND_CATEGORY_BY_NAME_QUERY = "SELECT * FROM category WHERE name = :p_name";
		public static final String FIND_CATEGORY_BY_ID_QUERY = "SELECT * FROM category WHERE category_id = :p_categoryid";
		public static final String SELECT_CATEGORY_QUERY = "SELECT * FROM category";
	}
	
	public static class FilmQuery {
		
		public static final String INSERT_FILM_QUERY = "INSERT INTO movie(title, description, release_year, duration, price, special_features, average_rating) "
				  									 + "VALUES(?, ?, ?, ?, ?, ?, ?)";
		public static final String INSERT_CUSTOMER_FILM_QUERY = "INSERT INTO movie_customer(customer_id, movie_id, price, date_buy)  VALUES(?, ?, ?, ?)";

		public static final String DELETE_FILM_QUERY = "DELETE FROM movie WHERE movie_id=";
		// строка удаления подчиненных записей актеров фильма
		public static final String DELETE_FILM_ACTOR_QUERY = "DELETE FROM movie_actor WHERE movie_id=";
		// строка удаления подчиненных записей категорий фильма
		public static final String DELETE_FILM_CATEGORY_QUERY = "DELETE FROM movie_category WHERE movie_id=";
		// строка удаления записb фильма пользователя 
		public static final String DELETE_CUSTOMER_FILM_QUERY = "DELETE FROM movie_customer WHERE customer_id = :custId AND movie_id = :movieId";
		// строка удаления подчиненных записей отзывов фильма
		public static final String DELETE_FILM_REVIEW_QUERY = "DELETE FROM review WHERE movie_id=";

		public static final String UPDATE_FILM_QUERY = "UPDATE movie SET title=?, description=?, release_year=?, duration=?, "
				  									 + "price=?, special_features=?, average_rating=?"
				  									 + " WHERE movie_id=?";

		public static final String SELECT_FILM_BY_MOVIEID_QUERY = "SELECT * FROM movie WHERE movie_id=?";
		public static final String SELECT_FILM_QUERY = "SELECT * FROM movie";

		public static final String SELECT_REVIEW_QUERY = "SELECT movie_id, review FROM v_movies_review WHERE movie_id = :movieId";
		public static final String FIND_FILM_BY_TITLE_QUERY = "SELECT * FROM movie WHERE title = :p_name";
		public static final String FIND_FILM_BY_ID_QUERY = "SELECT * FROM movie WHERE movie_id = :p_movieid";
		public static final String FIND_FILM_CUSTOMER_BY_CUSTID_MOVIEID_QUERY = "SELECT * FROM movie_customer WHERE customer_id = :p_custid AND movie_id = :p_movieid";
		public static final String FIND_FILM_CUSTOMER_BY_CUSTID_QUERY = "SELECT * FROM movie_customer WHERE customer_id = :p_custid";
		
		
	}
}
