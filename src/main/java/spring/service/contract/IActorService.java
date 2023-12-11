package spring.service.contract;

import java.util.List;

import spring.model.Actor;

public interface IActorService {
	
	Actor getActorByFirstName(final String firstName);
	
	Actor getActorBySecondName(final String secondName);
	
	Actor getActorById(long actorId);
	
	Actor create(final Actor actor);
	
	Actor update(Actor actor);

	void remove(final Actor actor);
	
	List<Actor> getAllActors();
}
