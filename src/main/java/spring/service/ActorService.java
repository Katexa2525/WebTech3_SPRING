package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.data.service.ActorDataService;
import spring.model.Actor;
import spring.service.contract.IActorService;

// Сервис для проброски данных актеров на контроллеры
@Service
@Transactional
public class ActorService implements IActorService {

	@Autowired
	private ActorDataService actorDataService;

	@Transactional(readOnly = true)
	public Actor getActorByFirstName(String firstName) {
		return actorDataService.getActorByFirstName(firstName);
	}

	@Transactional(readOnly = true)
	public Actor getActorBySecondName(String secondName) {
		return actorDataService.getActorBySecondName(secondName);
	}
	
	@Transactional(readOnly = true)
	public Actor getActorById(long actorId) {
		return actorDataService.getActorById(actorId);
	}

	public Actor create(Actor actor) {
		return actorDataService.create(actor);
	}

	public Actor update(Actor actor) {
		return actorDataService.update(actor);
	}

	public void remove(Actor actor) {
		actorDataService.remove(actor);
	}

	public List<Actor> getAllActors() {
		return actorDataService.getAllActors();
	}
}
