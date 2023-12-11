package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends AbstractController {

	@RequestMapping(value = { "/index", "/" })
	public String redirectToIndexPage() {
		return REDIRECT_TO_LOGIN_CONTROLLER;
	}

	@RequestMapping("/index")
	public ModelAndView redirectToHomePage() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
}