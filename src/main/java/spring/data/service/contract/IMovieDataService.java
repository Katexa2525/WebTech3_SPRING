package spring.data.service.contract;

import java.util.List;

import spring.model.Movie;
import spring.model.VMovieReview;

public interface IMovieDataService {
	
	Movie getFilmByTitle(final String title);

	Movie getFilmById(long movieId);
	
	Movie create(final Movie movie);
	
	Movie update(Movie movie);

	void remove(final Movie movie);
	
	List<Movie> getAllFilms();
	
	List<VMovieReview> getAllVMovieReviews(long movieId);

}
