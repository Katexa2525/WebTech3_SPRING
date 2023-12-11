package spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import spring.data.service.StringQueryService.ActorQuery;

//Класс модели для сохранения инфы по актерам
@Entity
@NamedQueries({
	@NamedQuery(name = "findActorByFirstName", query = ActorQuery.FIND_ACTOR_BY_FIRSTNAME_QUERY),
	@NamedQuery(name = "findActorBySecondName", query = ActorQuery.FIND_ACTOR_BY_SECONDNAME_QUERY),
	@NamedQuery(name = "findActorById", query = ActorQuery.FIND_ACTOR_BY_ID_QUERY)
			  })
public class Actor implements Serializable {
	
	@Id
	@GeneratedValue
	private int actorId;
	
	private String firstName;
	private String lastName;
	
	public Actor() {
		super();
	}
	
	// конструктор класса с тремя параметрами
	public Actor(int actorId, String firstName, String lastName) {
		this();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//конструктор класса с двумя параметрами
	public Actor(String firstName, String lastName) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// Свойства
	
	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
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

}

