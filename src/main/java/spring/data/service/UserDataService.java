package spring.data.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import spring.data.service.contract.IUserDataService;
import spring.model.Customer;
import spring.data.service.StringQueryService.UserQuery;

@Repository
public class UserDataService implements IUserDataService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer create(final Customer user) {
		entityManager.persist(user);
		return user;
	}

	@Override
	public Customer update(Customer user) {
		return entityManager.merge(user);
	}

	@Override
	public void remove(final Customer user) {
		entityManager.createNativeQuery(UserQuery.DELETE_CUSTOMER_QUERY + user.getCustomerId()).executeUpdate();
		Customer u = entityManager.find(Customer.class, user.getCustomerId());
		entityManager.remove(u);
	}

	@Override
	public Customer getUserByEmail(final String email) {
		TypedQuery<Customer> query = entityManager.createNamedQuery("findUserByEmail", Customer.class);
		query.setParameter("p_email", email);
		List<Customer> users = query.getResultList();
		return users != null && !users.isEmpty() ? users.get(0) : null;
	}
	
	@Override
	public Customer getUserByLogin(final String login) {
		TypedQuery<Customer> query = entityManager.createNamedQuery("findUserByLogin", Customer.class);
		query.setParameter("p_login", login);
		List<Customer> users = query.getResultList();
		return users != null && !users.isEmpty() ? users.get(0) : null;
	}

	@Override
	public boolean login(final String login, final String password) {
		TypedQuery<Customer> query = entityManager.createNamedQuery("findUserByLoginAndPassword", Customer.class);
		query.setParameter("p_login", login);
		query.setParameter("p_password", password);
		List<Customer> users = query.getResultList();
		return users != null && !users.isEmpty();
	}

	@Override
	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query = entityManager.createNamedQuery(UserQuery.SELECT_CUSTOMER_QUERY, Customer.class);
		List<Customer> сustomers = query.getResultList();
		return сustomers != null && !сustomers.isEmpty() ? сustomers : null;
	}

	@Override
	public Customer getUserById(int custId) {
		TypedQuery<Customer> query = entityManager.createNamedQuery("findUserById", Customer.class);
		query.setParameter("p_customerid", custId);
		List<Customer> users = query.getResultList();
		return users != null && !users.isEmpty() ? users.get(0) : null;
	}
}