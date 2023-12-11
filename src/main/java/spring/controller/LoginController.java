package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import spring.form.LoginForm;
import spring.model.Customer;
import spring.service.SessionData;
import spring.service.UserService;

// контроллер авторизации пользователя
@Controller
public class LoginController extends AbstractController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageProvider;

	@Autowired
	private SessionData sessionData;

	@RequestMapping(value = "/WEB-INF/views/login.jsp", method = RequestMethod.GET)
	public ModelAndView redirectToLoginPage() {

		if (sessionData.getUser() != null) {
			return new ModelAndView(REDIRECT_TO_LOGIN_CONTROLLER);
		}

		ModelAndView modelAndView = new ModelAndView(USER_LOGIN_PAGE);
		modelAndView.addObject("loginTabStyle", "active");
		modelAndView.addObject("loginForm", new LoginForm());
		return modelAndView;
	}

	@RequestMapping(value = "/WEB-INF/views/login.jsp", method = RequestMethod.POST)
	public ModelAndView doLogin(@Validated LoginForm loginForm,	BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView(USER_LOGIN_PAGE);
			modelAndView.addObject(ERROR_MESSAGE, messageProvider.getMessage("login.form.incomplete.details", null,	sessionData.getLocale()));
			return modelAndView;
		}

		if (!isValidUser(loginForm)) {
			ModelAndView modelAndView = new ModelAndView(USER_LOGIN_PAGE);
			modelAndView.addObject(ERROR_MESSAGE, messageProvider.getMessage("login.form.invalid.credentials", null,	sessionData.getLocale()));
			return modelAndView;
		}

		Customer user = userService.getUserByLogin(loginForm.getLogin());

		sessionData.setUser(user);

		return new ModelAndView(REDIRECT_TO_VIEW_MOVIES_CONTROLLER);
	}

	private boolean isValidUser(LoginForm loginForm) {
		return userService.isValidUser(loginForm.getLogin(), loginForm.getPassword());
	}

	@RequestMapping("/WEB-INF/views/login.jsp")
	public String logout(HttpSession session) {
		sessionData.setUser(null);
		session.invalidate();
		return REDIRECT_TO_LOGIN_CONTROLLER;
	}
}
