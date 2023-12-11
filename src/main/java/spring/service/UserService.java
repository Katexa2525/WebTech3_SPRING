package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.data.service.UserDataService;
import spring.model.Customer;
import spring.service.contract.IUserService;

//Сервис для проброски данных пользователей на контроллеры
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private UserDataService userDataService;

	
	public Customer create(final Customer user) {
		return userDataService.create(user);
	}
	
	public Customer update(Customer user) {
		return userDataService.update(user);
	}
	
	public void remove(final Customer user) {
		userDataService.remove(user);
	}
	
	@Transactional(readOnly = true)
	public Customer getUserByEmail(final String email) {
		return userDataService.getUserByEmail(email);
	}

	@Transactional(readOnly = true)
	public Customer getUserByLogin(final String login) {
		return userDataService.getUserByLogin(login);
	}
	
	@Transactional(readOnly = true)
	public boolean isValidUser(final String email, final String password) {
		return userDataService.login(email, password);
	}

	public List<Customer> getAllCustomers() {
		return userDataService.getAllCustomers();
	}

	@Override
	public Customer getUserById(int custId) {
		return userDataService.getUserById(custId);
	}

}
