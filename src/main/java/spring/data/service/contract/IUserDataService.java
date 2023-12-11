package spring.data.service.contract;

import java.util.List;

import spring.model.Customer;

// Интерфейс для сервиса по работе с пользователями
public interface IUserDataService {
	
	Customer getUserByEmail(final String email);
	
	Customer getUserByLogin(final String login);
	
	Customer getUserById(int custId);
	
	boolean login(final String user, final String password);
	
	Customer create(final Customer user);
	
	Customer update(Customer user);

	void remove(final Customer user);
	
	List<Customer> getAllCustomers();
}
