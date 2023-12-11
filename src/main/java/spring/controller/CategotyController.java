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

import spring.model.Category;
import spring.service.CategoryService;

//контроллер для методов по категориям жанрам фильмов
@Controller
public class CategotyController extends AbstractController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/")
	public ModelAndView homeCategory() {
	    List<Category> listCategory = categoryService.getAllCategories();
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("categoryes", listCategory);
	    modelAndView.setViewName("list-categoryes-db-spring");
	    return modelAndView;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showCreateCategory(Model model) {
		model.addAttribute("actor", new Category());
		return "add-actor-db-spring";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createNewCategory(@ModelAttribute Category category) {
		categoryService.create(category);
		return REDIRECT_TO_VIEW_CATEGOIES_CONTROLLER;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute Category category) {
		categoryService.update(category);
		return REDIRECT_TO_VIEW_CATEGOIES_CONTROLLER;
	}

	@RequestMapping(value = "/{actorId}/delete", method = RequestMethod.POST)
	public ModelAndView deleteCategory(@RequestParam long categoryId) {
        // удаляю фильм 
		Category category = categoryService.getCategoryById(categoryId);
		categoryService.remove(category);
        // обновляю страницу
		List<Category> listCategory = categoryService.getAllCategories();
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("categoryes", listCategory);
	    modelAndView.setViewName("list-categoryes-db-spring");
	    return modelAndView;
	}

}
