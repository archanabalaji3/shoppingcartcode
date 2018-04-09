package com.niit.shoppingcart.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;


@Controller
public class HomeController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;

	@Autowired
	HttpSession httpSession;
	
	Logger log= LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")										//http://localhost:8080/ShoppingCartFrontend
	public ModelAndView h()
	{
		log.debug("Start of the home method");
		
		ModelAndView mv= new ModelAndView("Home");
		List<Category> categories= categoryDAO.list();
		//mv.addObject("categories", categories);
		httpSession.setAttribute("categories", categories);
//		httpSession.setAttribute("imageDirectory", imageDirectory);
		
		log.debug("End of the home method");
		return mv;										
	}
	
	@GetMapping("/signin") //mapping
	public ModelAndView l()
	{
		log.debug("Start of the sign in method");
		
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("sinceUserClickedSignIn", true);
		
		log.debug("End of the sign in method");
		return mv;
	}
	
	@GetMapping("/signup")
	public ModelAndView r()
	{
		log.debug("Start of the sign up method");
		
		ModelAndView mv= new ModelAndView("Home");
		mv.addObject("sinceUserClickedSignUp", true);
		
		log.debug("End of the sign up method");
		return mv;
	}
	
	@GetMapping("/signout")
	public ModelAndView lg()
	{
		//at the time of login, we add userid in http session
		//at the time of logout, we need to remove user id from http session
		log.debug("Start of the logout method");
		
		ModelAndView mv= new ModelAndView("Home");
		httpSession.removeAttribute("loggedInUserId");
		httpSession.removeAttribute("ifLoggedIn");
		httpSession.removeAttribute("isAdmin");
		httpSession.removeAttribute("success");
		mv.addObject("logoutmessage", "You have successfully logged out");
		
		log.debug("End of the logout method");
		return mv;
	}
}
