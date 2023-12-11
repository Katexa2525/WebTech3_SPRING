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

import spring.model.Customer;
import spring.service.UserService;

//контроллер для методов по пользователям
@Controller
public class CustomerController extends AbstractController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public ModelAndView homeUser() {
	    List<Customer> listCustomer = userService.getAllCustomers();
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("customers", listCustomer);
	    modelAndView.setViewName("list-customers-db-spring");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showCreateUser(Model model) {
		model.addAttribute("customer", new Customer());
		return "add-customer-db-spring";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createNewUser(@ModelAttribute Customer customer) {
		userService.create(customer);
		return REDIRECT_TO_VIEW_CUSTOMERS_CONTROLLER;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute Customer customer) {
		userService.update(customer);
		return REDIRECT_TO_VIEW_CUSTOMERS_CONTROLLER;
	}

	@RequestMapping(value = "/{customerId}/delete", method = RequestMethod.POST)
	public ModelAndView deleteUser(@RequestParam int customerId) {
        // удаляю фильм 
		Customer customer = userService.getUserById(customerId);
		userService.remove(customer);
        // обновляю страницу
		List<Customer> listCustomer = userService.getAllCustomers();
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("customers", listCustomer);
	    modelAndView.setViewName("list-customers-db-spring");
	    return modelAndView;
	}

}
