package spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import spring.data.service.StringQueryService.UserQuery;


@Entity
@NamedQueries({
	@NamedQuery(name = "findUserByEmail", query = UserQuery.FIND_USER_BY_EMAIL_QUERY),
	@NamedQuery(name = "findUserByLogin", query = UserQuery.FIND_USER_BY_LOGIN_QUERY),
	@NamedQuery(name = "findUserByLoginAndPassword", query = UserQuery.FIND_USER_BY_LOGIN_PASSWORD_QUERY),
	@NamedQuery(name = "findUserById", query = UserQuery.FIND_USER_BY_ID_QUERY),
			  })
public class Customer implements Serializable {

	@Id
	@GeneratedValue
	private int customerId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private int active;
	private float discount;
	private String bonus;
	private int isAdmin;
	private String password;
	
	public Customer() {
		super();
	}

	// конструктор класса с 9 параметрами
			public Customer(int customerId, String firstName, String lastName, String email, String address, 
							int active, float discount, String bonus, int isAdmin, String password) {
				this();
				this.customerId = customerId;
				this.firstName = firstName;
				this.lastName = lastName;
				this.email = email;
				this.address = address;
				this.active = active;
				this.discount = discount;
				this.bonus = bonus;
				this.isAdmin = isAdmin;
				this.password = password;
			}
			
			//конструктор класса с 8 параметрами
			public Customer(String firstName, String lastName, String email, String address, 
							int active, float discount, String bonus, int isAdmin, String password) {
				this();
				this.firstName = firstName;
				this.lastName = lastName;
				this.email = email;
				this.address = address;
				this.active = active;
				this.discount = discount;
				this.bonus = bonus;
				this.isAdmin = isAdmin;
				this.password = password;
			}
			
			// Свойства
			
			public int getCustomerId() {
				return customerId;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
			
			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}
			
			public int getActive() {
				return active;
			}

			public void setActive(int active) {
				this.active = active;
			}
			
			public float getDiscount() {
				return discount;
			}

			public void setDiscount(float discount) {
				this.discount = discount;
			}
			
			public String getBonus() {
				return bonus;
			}

			public void setBonus(String bonus) {
				this.bonus = bonus;
			}
			
			public int getIsAdmin() {
				return isAdmin;
			}

			public void setIsAdmin(int isAdmin) {
				this.isAdmin = isAdmin;
			}
			
			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}}

