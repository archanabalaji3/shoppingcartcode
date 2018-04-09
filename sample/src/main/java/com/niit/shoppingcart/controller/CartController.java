package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Product;

@Controller
public class CartController {
Logger log= LoggerFactory.getLogger(CartController.class);
	
	@Autowired 
	HttpSession httpSession;

	@Autowired
	private CartDAO cartDAO; 
	
	@Autowired
	private Cart cart; 
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
		
	@GetMapping("product/cart/add")
	public ModelAndView addToCart(@RequestParam("productID") String productId)
	{
		log.debug("Starting of the addToCart method");
		
		ModelAndView mv= new ModelAndView("Home");
		String loggedInUserID= (String)httpSession.getAttribute("loggedInUserID");
		if (loggedInUserID== null)
		{
			mv.addObject("errormsg", "Please login to add any product to cart");
			return mv;
		}
		product= productDAO.get(productId);
		
		cart.setEmailid(loggedInUserID); 				//from Cart.java domain class
		cart.setProductName(product.getName());
		cart.setPrice(product.getPrice());
		cart.setQuantity(1);
		cart.setProductID(productId);
		cart.setId();
		
		if (cartDAO.save(cart)){
			mv.addObject("successmsg", "Product added to cart successfully");
		}
		else{
			mv.addObject("errormsg", "Could not add the product to cart. Please try again.");
		}

		log.debug("End of the addToCart method");
		return mv;
	}
	
	@GetMapping("/mycart")
	public ModelAndView getMyCartDetails()
	{
		log.debug("Starting of the method getMyCartDetails");
		
		ModelAndView mv= new ModelAndView("Home");
		String loggedInUserID= (String) httpSession.getAttribute("loggedInUserID");
		
		log.info("Logged in user id: "+ loggedInUserID);
		
		if (loggedInUserID== null)
		{
			mv.addObject("errormsg", "Please login to see your cart details");
			return mv;
		}
		List<Cart> cartList= cartDAO.list(loggedInUserID);
		mv.addObject("cartList", cartList);

		
		log.debug("No of products in cart"+ cartList.size());
		log.debug("Ending of the method getMyCartDetails");
		return mv;
	}
}
