package spring.controller;

import org.springframework.web.servlet.ModelAndView;

public class AbstractController {

	protected static final String ERROR_MESSAGE = "error";

	public static final String REDIRECT_TO_VIEW_MOVIES_CONTROLLER = "redirect:/WEB-INF/views/list-movies-db-spring";
	public static final String REDIRECT_TO_VIEW_ACTORS_CONTROLLER = "redirect:/WEB-INF/views/list-actor-db-spring";
	public static final String REDIRECT_TO_VIEW_CATEGOIES_CONTROLLER = "redirect:/WEB-INF/views/list-categoryes-db-spring";
	public static final String REDIRECT_TO_VIEW_MOVIES_CUSTOMER_CONTROLLER = "redirect:/WEB-INF/views/list-customer-movies-db-spring";
	public static final String REDIRECT_TO_VIEW_CUSTOMERS_CONTROLLER = "redirect:/WEB-INF/views/list-customers-db-spring";
	public static final String REDIRECT_TO_VIEW_REVIEW_CONTROLLER = "redirect:/WEB-INF/views/list-review-db-spring";

	protected static final String USER_LOGIN_PAGE = "/WEB-INF/views/login.jsp";

	protected static final String ERROR_PAGE = "error";

	protected static final String REDIRECT_TO_LOGIN_CONTROLLER = "redirect:/WEB-INF/views/login.jsp";

	protected ModelAndView redirectToErrorPageWithMessage(String errorMessage) {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		modelAndView.addObject(ERROR_MESSAGE, errorMessage);
		return modelAndView;
	}

}
