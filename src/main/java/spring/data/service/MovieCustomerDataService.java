package spring.data.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import spring.data.service.contract.IMovieCustomerDataService;
import spring.model.MovieCustomer;

public class MovieCustomerDataService implements IMovieCustomerDataService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public MovieCustomer getFilmCustomerByCustIdAndMovieId(int custId, int movieId) {
		TypedQuery<MovieCustomer> query = entityManager.createNamedQuery("findFilmCustomerByCustIdAndMovieId", MovieCustomer.class);
		query.setParameter("p_custid", custId);
		query.setParameter("p_movieid", movieId);
		List<MovieCustomer> moviesCust = query.getResultList();
		return moviesCust != null && !moviesCust.isEmpty() ? moviesCust.get(0) : null;
	}
	
	@Override
	public List<MovieCustomer> getFilmCustomerByCustId(int custId) {
		TypedQuery<MovieCustomer> query = entityManager.createNamedQuery("findFilmCustomerByCustId", MovieCustomer.class);
		query.setParameter("p_custid", custId);
		List<MovieCustomer> moviesCust = query.getResultList();
		return moviesCust != null && !moviesCust.isEmpty() ? moviesCust : null;
	}

	@Override
	public MovieCustomer create(MovieCustomer movieCus) {
		entityManager.persist(movieCus);
		return null;
	}

	@Override
	public MovieCustomer update(MovieCustomer movieCus) {
		return entityManager.merge(movieCus);
	}

	@Override
	public void remove(MovieCustomer movieCus) {
		TypedQuery<MovieCustomer> query = entityManager.createNamedQuery("removeFilmCustomerByCustIdAndMovieId", MovieCustomer.class);
		query.setParameter("p_custid", movieCus.getCustomerId());
		query.setParameter("p_movieid", movieCus.getMovieId());
		query.executeUpdate();
		MovieCustomer m = query.getSingleResult();
		entityManager.remove(m);
	}

}
