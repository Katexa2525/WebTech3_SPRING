package spring.service;

import java.io.Serializable;
import java.util.Locale;

import spring.model.Customer;

// класс настройки пользовательской сессии
public class SessionData implements Serializable {
	private static final long serialVersionUID = 1L;

	public SessionData() {
		super();
	}

	private Customer user;

	private Locale locale;

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
