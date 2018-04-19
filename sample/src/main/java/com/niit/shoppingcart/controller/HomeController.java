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

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;


@Controller                //The @Controller annotation indicates that a particular class serves the role of a controller.
public class HomeController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private Product product;
	@Autowired
	private ProductDAO productDAO;

	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("home");
    	List<Category> categories = categoryDAO.list(); // we need to fetch all the categories
		List<Product> products = productDAO.list();
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<Cart> cartList = cartDAO.list(loggedInUserID);
		int cartSize = cartList.size();
		httpSession.setAttribute("cartSize", cartSize);
		httpSession.setAttribute("categories", categories);
		httpSession.setAttribute("products",products);
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedLogin", true);
		return mv;
	}

	@GetMapping("/logout")
	public ModelAndView logout() { //During login, we add user id in http session, during logout, we need to remove user id from http session.
		
		ModelAndView mv = new ModelAndView("home");
		List<Category> categories = categoryDAO.list();
		List<Product> products = productDAO.list();
		httpSession.setAttribute("categories", categories);
		httpSession.setAttribute("products",products);
		httpSession.removeAttribute("cartSize");
		httpSession.removeAttribute("isAdmin");
		httpSession.removeAttribute("isLoggedIn");
		httpSession.removeAttribute("welcomeMessage");
		httpSession.removeAttribute("loggedInUserID");
		mv.addObject("logoutMessage", "You are successfully logged out");
		return mv;
	}

	@RequestMapping("/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedRegister", true);
		return mv;
	}
	
	@RequestMapping("/contactus")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedContact", true);
		return mv;
	}
	
	@RequestMapping("/aboutus")
	public ModelAndView aboutus() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedAboutus", true);
		return mv;
	}
	
	@RequestMapping("/h")
	public ModelAndView hom() {
		ModelAndView mv = new ModelAndView("home");
		List<Category> categories = categoryDAO.list();
		List<Product> products = productDAO.list();
		mv.addObject("categories", categories);
		mv.addObject("products",products);
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<Cart> cartList = cartDAO.list(loggedInUserID);
		int cartSize = cartList.size();
		httpSession.setAttribute("cartSize", cartSize);
		return mv;
	}
}
