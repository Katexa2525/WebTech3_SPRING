package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import spring.data.service.MovieCustomerDataService;
import spring.model.MovieCustomer;
import spring.service.contract.IMovieCustomerService;

public class MovieCustomerService implements IMovieCustomerService {

	@Autowired
	private MovieCustomerDataService movieCustomerDataService;

	@Transactional(readOnly = true)
	public MovieCustomer getFilmCustomerByCustIdAndMovieId(int custId, int movieId) {
		return movieCustomerDataService.getFilmCustomerByCustIdAndMovieId(custId, movieId);
	}
	
	@Transactional(readOnly = true)
	public List<MovieCustomer> getFilmCustomerByCustId(int custId) {
		return movieCustomerDataService.getFilmCustomerByCustId(custId);
	}

	public MovieCustomer create(MovieCustomer movieCus) {
		return movieCustomerDataService.create(movieCus);
	}

	public MovieCustomer update(MovieCustomer movieCus) {
		return movieCustomerDataService.update(movieCus);
	}

	public void remove(MovieCustomer movieCus) {
		movieCustomerDataService.remove(movieCus);
	}

}
