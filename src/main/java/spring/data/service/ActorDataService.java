package spring.data.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import spring.data.service.StringQueryService.ActorQuery;
import spring.data.service.StringQueryService.FilmQuery;
import spring.data.service.contract.IActorDataService;
import spring.model.Actor;
import spring.model.Movie;

public class ActorDataService implements IActorDataService  {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Actor getActorByFirstName(String firstName) {
		TypedQuery<Actor> query = entityManager.createNamedQuery("findActorByFirstName", Actor.class);
		query.setParameter("p_name", firstName);
		List<Actor> actors = query.getResultList();
		return actors != null && !actors.isEmpty() ? actors.get(0) : null;
	}

	@Override
	public Actor getActorBySecondName(String secondName) {
		TypedQuery<Actor> query = entityManager.createNamedQuery("findActorBySecondName", Actor.class);
		query.setParameter("p_name", secondName);
		List<Actor> actors = query.getResultList();
		return actors != null && !actors.isEmpty() ? actors.get(0) : null;
	}

	@Override
	public Actor create(Actor actor) {
		entityManager.persist(actor);
		return null;
	}

	@Override
	public Actor update(Actor actor) {
		return entityManager.merge(actor);
	}

	@Override
	public void remove(Actor actor) {
		entityManager.createNativeQuery(ActorQuery.DELETE_ACTOR_QUERY + actor.getActorId()).executeUpdate();
		Actor act = entityManager.find(Actor.class, actor.getActorId());
		entityManager.remove(act);
	}

	@Override
	public List<Actor> getAllActors() {
		TypedQuery<Actor> query = entityManager.createNamedQuery(ActorQuery.SELECT_ACTOR_QUERY, Actor.class);
		List<Actor> actors = query.getResultList();
		return actors != null && !actors.isEmpty() ? actors : null;
	}

	@Override
	public Actor getActorById(long actorId) {
		TypedQuery<Actor> query = entityManager.createNamedQuery("findFilmById", Actor.class);
		query.setParameter("p_actorid", actorId);
		List<Actor> actor = query.getResultList();
		return actor != null && !actor.isEmpty() ? actor.get(0) : null;
	}

}
