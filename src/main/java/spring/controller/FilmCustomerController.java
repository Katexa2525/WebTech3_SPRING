package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.model.MovieCustomer;
import spring.service.MovieCustomerService;

//контроллер для методов по фильмам пользователя
@Controller
public class FilmCustomerController extends AbstractController {

	@Autowired
	private MovieCustomerService movieCustomerService;

	@RequestMapping(value = "/movies/{custId}", method = RequestMethod.GET)
	public ModelAndView homeMovieCustomer(@RequestParam int custId) {
	    List<MovieCustomer> listMovieCustomer = movieCustomerService.getFilmCustomerByCustId(custId);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("movies", listMovieCustomer);
	    modelAndView.setViewName("list-customer-movies-db-spring");
	    return modelAndView;
	}

}
