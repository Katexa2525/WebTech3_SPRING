package spring.data.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import spring.data.service.StringQueryService.FilmQuery;
import spring.data.service.contract.IMovieDataService;
import spring.model.Movie;
import spring.model.VMovieReview;

public class MovieDataService implements IMovieDataService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Movie getFilmByTitle(String title) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("findFilmByTitle", Movie.class);
		query.setParameter("p_name", title);
		List<Movie> movies = query.getResultList();
		return movies != null && !movies.isEmpty() ? movies.get(0) : null;
	}

	@Override
	public Movie create(Movie movie) {
		entityManager.persist(movie);
		return null;
	}

	@Override
	public Movie update(Movie movie) {
		return entityManager.merge(movie);
	}

	@Override
	public void remove(Movie movie) {
		entityManager.createNativeQuery(FilmQuery.DELETE_FILM_QUERY + movie.getMovie_id()).executeUpdate();
		// удаляю подчиненные данные
		entityManager.createNativeQuery(FilmQuery.DELETE_FILM_ACTOR_QUERY + movie.getMovie_id()).executeUpdate();
		entityManager.createNativeQuery(FilmQuery.DELETE_FILM_CATEGORY_QUERY + movie.getMovie_id()).executeUpdate();
		entityManager.createNativeQuery(FilmQuery.DELETE_FILM_REVIEW_QUERY + movie.getMovie_id()).executeUpdate();
		Movie m = entityManager.find(Movie.class, movie.getMovie_id());
		entityManager.remove(m);
	}

	@Override
	public List<Movie> getAllFilms() {
		TypedQuery<Movie> query = entityManager.createNamedQuery(FilmQuery.SELECT_FILM_QUERY, Movie.class);
		List<Movie> movies = query.getResultList();
		return movies != null && !movies.isEmpty() ? movies : null;
	}

	@Override
	public Movie getFilmById(long movieId) {
		TypedQuery<Movie> query = entityManager.createNamedQuery("findFilmById", Movie.class);
		query.setParameter("p_movieid", movieId);
		List<Movie> movies = query.getResultList();
		return movies != null && !movies.isEmpty() ? movies.get(0) : null;
	}

	@Override
	public List<VMovieReview> getAllVMovieReviews(long movieId) {
		TypedQuery<VMovieReview> query = entityManager.createQuery(FilmQuery.SELECT_REVIEW_QUERY, VMovieReview.class);
		query.setParameter("movieId", movieId);
		List<VMovieReview> vMovieReview = query.getResultList();
		return vMovieReview != null && !vMovieReview.isEmpty() ? vMovieReview : null;
	}

}
