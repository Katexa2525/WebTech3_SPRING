package spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Customer;
import spring.model.Movie;
import spring.model.MovieCustomer;
import spring.model.VMovieReview;
import spring.service.ActorService;
import spring.service.MovieCustomerService;
import spring.service.MovieService;
import spring.service.UserService;

//контроллер для методов по фильмам
@Controller
public class FilmController extends AbstractController  {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieCustomerService movieCustomerService;
	
	@Autowired
	private ActorService actorService;

	//@RequestMapping(value = "/WEB-INF/views/list-movies-db-spring.jsp", method = RequestMethod.GET)
	@RequestMapping("/films")
	public ModelAndView homeMovie() {
	    List<Movie> listMovie = movieService.getAllFilms();
	    ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("movies", listMovie);
	    modelAndView.setViewName("list-movies-db-spring");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showCreateMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "add-film-db-spring";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createNewMovie(@ModelAttribute Movie movie) {
		movieService.create(movie);
		return REDIRECT_TO_VIEW_MOVIES_CONTROLLER;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateMovie(@ModelAttribute Movie film) {
		movieService.update(film);
		return REDIRECT_TO_VIEW_MOVIES_CONTROLLER;
	}
	
	@RequestMapping(value = "/{movieId}/review", method = RequestMethod.GET)
	public ModelAndView movieReview(@RequestParam long movieId) {
		
		List<VMovieReview> listVMovieReview = movieService.getAllVMovieReviews(movieId);
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("reviews", modelAndView);
	    modelAndView.setViewName("list-review-db-spring");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public String buyMovie(@ModelAttribute Movie film) {
		
		Customer customer = userService.getUserById(11);
		MovieCustomer movieCustomer = new MovieCustomer();
		movieCustomer.setCustomerId(customer.getCustomerId());
		movieCustomer.setMovieId(film.getMovie_id());
		
		Float price = film.getPrice();
		Float finalPrice = price - ((price/100) * customer.getDiscount());
		movieCustomer.setPrice(finalPrice);
		
		movieCustomer.setDateBuy(LocalDate.now().toString());
		movieCustomerService.create(movieCustomer);
		return REDIRECT_TO_VIEW_MOVIES_CONTROLLER;
	}

	@RequestMapping(value = "/{movieId}/delete", method = RequestMethod.POST)
	public ModelAndView deleteMovie(@RequestParam long movieId) {
        // удаляю фильм 
		Movie movie = movieService.getFilmById(movieId);
		movieService.remove(movie);
        // обновляю страницу
		List<Movie> listMovie = movieService.getAllFilms();
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("movies", listMovie);
	    modelAndView.setViewName("list-movies-db-spring");
	    return modelAndView;
	}

}
