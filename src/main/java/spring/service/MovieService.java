package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.data.service.MovieDataService;
import spring.model.Movie;
import spring.model.VMovieReview;
import spring.service.contract.IMovieService;

//Сервис для проброски данных по фильмам на контроллеры
@Service
@Transactional
public class MovieService implements IMovieService {

	@Autowired
	private MovieDataService movieDataService;

	@Transactional(readOnly = true)
	public Movie getFilmByTitle(String title) {
		return movieDataService.getFilmByTitle(title);
	}
	
	@Transactional(readOnly = true)
	public Movie getFilmById(long movieId) {
		return movieDataService.getFilmById(movieId);
	}

	public Movie create(Movie movie) {
		return movieDataService.create(movie);
	}

	public Movie update(Movie movie) {
		return movieDataService.update(movie);
	}

	public void remove(spring.model.Movie movie) {
		movieDataService.remove(movie);
	}

	public List<Movie> getAllFilms() {
		return movieDataService.getAllFilms();
	}

	@Override
	public List<VMovieReview> getAllVMovieReviews(long movieId) {
		return movieDataService.getAllVMovieReviews(movieId);
	}

}
