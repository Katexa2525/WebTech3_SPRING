package spring.service.contract;

import java.util.List;

import spring.model.Customer;

public interface IUserService {
	
	Customer getUserByEmail(final String email);
	
	Customer getUserByLogin(final String login);
	
	Customer getUserById(int custId);
	
	boolean isValidUser(final String email, final String password);
	
	Customer create(final Customer user);
	
	Customer update(Customer user);
	
	void remove(final Customer user);
	
	List<Customer> getAllCustomers();
}
