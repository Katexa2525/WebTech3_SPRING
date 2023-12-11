package spring.data.service.contract;

import java.util.List;

import spring.model.MovieCustomer;

public interface IMovieCustomerDataService {
	
	MovieCustomer getFilmCustomerByCustIdAndMovieId(int custId, int movieId);
	
	List<MovieCustomer> getFilmCustomerByCustId(int custId);
	
	MovieCustomer create(final MovieCustomer movieCus);
	
	MovieCustomer update(MovieCustomer movieCus);

	void remove(final MovieCustomer movieCus);
}
