package spring.data.service.contract;

import java.util.List;

import spring.model.Actor;

//Интерфейс для сервиса по работе с актерами
public interface IActorDataService {

	Actor getActorByFirstName(final String firstName);
	
	Actor getActorBySecondName(final String secondName);
	
	Actor getActorById(long actorId);
	
	Actor create(final Actor actor);
	
	Actor update(Actor actor);

	void remove(final Actor actor);
	
	List<Actor> getAllActors();
}
