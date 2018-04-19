package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SpringSecurityController {
	
	public static Logger log = LoggerFactory.getLogger(SpringSecurityController.class);
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private Cart cart;
	@Autowired
	private HttpSession session;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;
	@Autowired
	private Product product;
	@Autowired
	private ProductDAO productDAO;

	                                 // authentication-failure-forward-url="/loginError"
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) 
	{
		log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage", "Invalid Credentials.  Please try again.");
		log.debug("Ending of the method loginError");
		return "home";
	}

	                              // <security:access-denied-handler error-page="/accessDenied" />
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) 
	{
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return "home";
	}

	@RequestMapping(value = "checkRole", method = RequestMethod.GET)
	public ModelAndView checkRole(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		log.debug("starting of the method validate");
		ModelAndView mv = new ModelAndView("home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userID = auth.getName();
		session.setAttribute("loggedInUser", userID);
		if (request.isUserInRole("A")) 
		{
			session.setAttribute("isAdmin", true);
		} else 
		{
			session.setAttribute("isAdmin", false);
			session.setAttribute("cart", cart);
			List<Cart> cartList = cartDAO.list(userID);           // Fetch the cart list based on user ID
			session.setAttribute("cartList", cartList);
			session.setAttribute("cartSize", cartList.size());
		}
		log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping("/secure_logout")
	public ModelAndView secureLogout()                          //what attach to session at the time login need to remove when logout. 
	{ 
		session.invalidate();                                   //After logout use should able to browse the categories and products
		ModelAndView mv = new ModelAndView("Home");             //we invalidated the session, need to load these data again
		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("productList", productDAO.list());     
		return mv;
	}
}
