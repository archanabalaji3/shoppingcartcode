package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	@Autowired
	HttpSession httpSession;

	@PostMapping("/category/save/")
	public ModelAndView saveCategory(@RequestParam("id") String id,@RequestParam("name") String name,
			                          @RequestParam("description") String description) 
	{
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		if (categoryDAO.save(category)) {
			mv.addObject("categorySuccessMessage", "The category created successfully");
		} else {
			mv.addObject("categoryErrorMessage", "Coulc not able to create category.  please contact admin");
		}
		return mv;
	}

	@PutMapping("/category/update/")
	public ModelAndView updateCategory(@ModelAttribute Category category) {
		// navigate to home page
		ModelAndView mv = new ModelAndView("home");

		// call save method of categoryDAO
		if (categoryDAO.update(category) == true) {
			// add success message
			mv.addObject("successMessage", "The category updated successfully");
		} else {
			// add failure message
			mv.addObject("errorMessage", "Could not update the category.");

		}
		return mv;

	}

	@GetMapping("/category/delete")
	public ModelAndView deleteCategory(@RequestParam String id) 
	{
		System.out.println("going to delete category : " + id);
		ModelAndView mv = new ModelAndView("redirect:/managecategories");   //navigate to home page
		if (categoryDAO.delete(id) == true) 
		{                                                                  // add success message
			mv.addObject("successMessage", "The category deleted successfully");
		} else 
		{
			mv.addObject("errorMessage", "Could not delete the category."); // add failure message
		}
		return mv;
	}

	@GetMapping("/category/edit")
	public ModelAndView editCategory(@RequestParam String id) 
	{
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		category = categoryDAO.get(id);                                    // based on category id fetch category details.
		httpSession.setAttribute("selectedCategory", category);
		return mv;
	}

	@GetMapping("/categories")
	public ModelAndView getAllCategories() {
		ModelAndView mv = new ModelAndView("home");
		List<Category> categories = categoryDAO.list();
		mv.addObject("categories", categories);
		return mv;
	}
}
