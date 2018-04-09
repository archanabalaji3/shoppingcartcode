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
	
	Logger log= LoggerFactory.getLogger(CategoryController.class);
	
	@PostMapping("/category/save/")
	public ModelAndView saveCategory(@RequestParam("category_id") String id, @RequestParam("name") String name, 
									 @RequestParam("description") String description)
	{
		log.debug("Start of the category save method");
		
		ModelAndView mv= new ModelAndView("redirect:/managecategories");
		category.setCategory_id(id);
		category.setName(name);
		category.setDescription(description);
		
		if (categoryDAO.save(category))
		{
			mv.addObject("categorysuccess", "Category saved successfully");
			category.setCategory_id("");
			category.setName("");
			category.setDescription("");
			
			List<Category> categories = categoryDAO.list();					//fetches all categories again
			httpSession.setAttribute("categories", categories);				//and sets to http session
		}
		else{
			mv.addObject("categoryerror", "Couldn't save");
		}
		
		log.debug("End of the category save method");
		return mv;
	}
		
	@PutMapping("/category/update/")
	public ModelAndView updateCategory(@ModelAttribute Category category)
	{
		log.debug("Start of the category update method");
		
		ModelAndView mv= new ModelAndView("Home");
		if (categoryDAO.update(category)==true){
			mv.addObject("categorysuccess", "Successfully updated");
		}
		else{
			mv.addObject("categoryerror", "Failed to update");
		}

		log.debug("End of the category update method");
		return mv;
	}
	
	@GetMapping("/Allcategories")
	public ModelAndView  getAllCategories()
	{
		log.debug("Start of the get all categories method");
		
		ModelAndView mv= new ModelAndView("Home");
		List<Category> categories= categoryDAO.list();
		mv.addObject("categories", categories);

		log.debug("End of the get all categories method");
		return mv;
	}
	
	@GetMapping("/category/delete")
	public ModelAndView deleteCategory(@RequestParam("id") String id) //@RequestParam("category_id")
	{
		log.debug("Start of the category delete method");
		
		ModelAndView mv= new ModelAndView("redirect:/managecategories");
		if (categoryDAO.delete(id)==true){
			mv.addObject("categorysuccess", "Deleted");
		}
		else{
			mv.addObject("categoryerror", "Not deleted");
		}

		log.debug("End of the category delete method");
		return mv;
	}
	
	@GetMapping("/category/edit")
	public ModelAndView editCategory(@RequestParam("id") String id)
	{
		log.debug("Start of the category edit method");
		
		ModelAndView mv= new ModelAndView("redirect:/managecategories");
		category= categoryDAO.get(id);
		httpSession.setAttribute("category", category);

		log.debug("End of the category edit method");
		return mv;
	}	


}
