package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Controller 
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private User user;
	@Autowired
	private Cart cart;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	HttpSession httpSession;
	
	@PostMapping("validate")       //send user id and password from jsp to controller,it should validate the credentials.
	public ModelAndView validate(@RequestParam("uname") String username, @RequestParam("psw") String password)
	{
		ModelAndView mv = new ModelAndView("home");
		user = userDAO.validate(username, password);
		if (user == null) 
		{
			mv.addObject("errorMessage", "Invalid user, Pls try again.");
			mv.addObject("loginerror", true);
		} else 
		{
			httpSession.setAttribute("welcomeMessage", "Welcome Mr./Ms " + user.getName());  //valid credentials.
			httpSession.setAttribute("loggedInUserID", user.getEmailID());
			httpSession.setAttribute("isLoggedIn", true);
			List<Cart> cartList = cartDAO.list(user.getEmailID());
			int cartSize = cartList.size();                                                  
			httpSession.setAttribute("cartSize",cartSize);
			httpSession.setAttribute("cartList", cartList);
			if (user.getRole() == 'A') 
			{
				httpSession.setAttribute("isAdmin", true);
			}
		}
		return mv;
	}

	@PostMapping("registration")
	public ModelAndView registration(@RequestParam("email") String email, @RequestParam("psw") String password,
			                         @RequestParam("mob") String mobile, @RequestParam("name") String name) 
	{
		ModelAndView mv = new ModelAndView("home");
		user.setEmailID(email);
		user.setMobile(mobile);
		user.setName(name);
		user.setPwd(password);
		System.out.println(user.getEmailID());
		userDAO.save(user);
		mv.addObject("isclickedregister",true);
		return mv;
	}
}
