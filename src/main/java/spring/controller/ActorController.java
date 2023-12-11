package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Actor;
import spring.service.ActorService;

//контроллер для методов по актерам фильмов
@Controller
public class ActorController extends AbstractController {

	@Autowired
	private ActorService actorService;
	
	@RequestMapping("/")
	public ModelAndView homeActor() {
	    List<Actor> listActor = actorService.getAllActors();
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("actors", listActor);
	    modelAndView.setViewName("list-actor-db-spring");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showCreateActor(Model model) {
		model.addAttribute("actor", new Actor());
		return "add-actor-db-spring";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createNewActor(@ModelAttribute Actor actor) {
		actorService.create(actor);
		return REDIRECT_TO_VIEW_ACTORS_CONTROLLER;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateActor(@ModelAttribute Actor actor) {
		actorService.update(actor);
		return REDIRECT_TO_VIEW_ACTORS_CONTROLLER;
	}

	@RequestMapping(value = "/{actorId}/delete", method = RequestMethod.POST)
	public ModelAndView deleteActor(@RequestParam long actorId) {
        // удаляю фильм 
		Actor actor = actorService.getActorById(actorId);
		actorService.remove(actor);
        // обновляю страницу
		List<Actor> listActor = actorService.getAllActors();
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("actors", listActor);
	    modelAndView.setViewName("list-actor-db-spring");
	    return modelAndView;
	}

}
