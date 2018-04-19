package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Controller
public class CartController {
	
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Cart cart;
	@Autowired
	private Product product;
	@Autowired
	private HttpSession httpSession;

	@GetMapping("/cart/add/{productID}")
	public ModelAndView addToCart(@PathVariable String productID)
	{
		ModelAndView mv = new ModelAndView("redirect:/");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		if (loggedInUserID == null) 
		{
			mv.addObject("errorMessage", "Please login to add any product to cart");
			return mv;
		}
		product = productDAO.get(productID);   // get the other details of product from productDAO.get()
		cart.setEmailID(loggedInUserID);
		cart.setPrice(product.getPrice());
		cart.setProductID(productID);
		cart.setProductName(product.getName());
		cart.setQuantity(1);
		cart.setId();                         // to set a random number.
		if (cartDAO.save(cart)) 
		{
			mv.addObject("successMessage", "Product added to cart");
			List<Cart> cartList= cartDAO.list(loggedInUserID);
			httpSession.setAttribute("cartSize", cartList.size());
		} else 
		{
			mv.addObject("errorMessage", "Could not add the product to cart..please try after some time");
		}
		return mv;
	}

	
	@GetMapping("/mycart")                                         // get my cart details
	public ModelAndView getMyCartDetails() {
		log.debug("Starting of the method getMyCartDetails");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedMyCart", true);
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID"); // it will return all the products which are added to cart
		log.info("Logged in user id : " + loggedInUserID);
		if (loggedInUserID == null) {
			mv.addObject("errorMessage", "Please login to see your cart details");
			return mv;
		}
		else
		{
			List<Cart> cartList= cartDAO.list(loggedInUserID);
			if (cartList==null)
			{
				mv.addObject("noItems", "Your cart is empty");
			}
			else
			{
				mv.addObject("cartDetails", true);
				mv.addObject("cartList",cartList);
				mv.addObject("cartSize", cartList.size());
				int cartsum = 0;
				for (Cart a:cartList) 
				{
					cartsum = cartsum + a.getPrice();
				}
				httpSession.setAttribute("cartsum", cartsum);
				log.debug("No of products in cart"+ cartList.size());
				log.debug("Ending of the method getMyCartDetails");
			}
		}
		return mv;
	}
	
	@PostMapping("/editcartqty/{id}")
	public ModelAndView editProductQuantity(@PathVariable("id") int id)
	{
		log.debug("Starting of the method editProductQuantity");
		ModelAndView mv= new ModelAndView("redirect:/mycart");
		cart=cartDAO.get(id);
		cart.setQuantity((cart.getQuantity()+1));
		cart.setPrice(cart.getPrice()*cart.getQuantity());
		cartDAO.update(cart);
		log.debug("Ending of the method editProductQuantity");
		return mv;
	}
	
	@PostMapping("/deleteFromCart")
	public ModelAndView deleteFromCart(@RequestParam int id) {
		log.debug("Starting of the method removeProductFromCart");
		ModelAndView mv = new ModelAndView("redirect:/mycart");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		cartDAO.delete(id);
		List<Cart> cartList = cartDAO.list(loggedInUserID);
		int cartSize = cartList.size();
		httpSession.setAttribute("cartSize", cartSize);
		mv.addObject("cartList", cartList);
		return mv;
	}

	@PostMapping("/checkout")
	public ModelAndView checkout() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("checkoutClicked", true);
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<Cart> cartList = cartDAO.list(loggedInUserID);
		httpSession.setAttribute("cartList", cartList);
		int cartsum = 0;
		for (Cart a:cartList) {
			cartsum = cartsum + a.getPrice();
		}
		httpSession.setAttribute("cartsum", cartsum);
		int total = cartsum+100;
		httpSession.setAttribute("total", total);
		return mv;
	}
	
	@PostMapping("/placeOrder")
		public ModelAndView placeOrder(@RequestParam("emailID") String emailID){
		ModelAndView mv = new ModelAndView("home");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		if(cartDAO.deleteCart("loggedInUserID")==true)
		{
			List<Cart> cartList = cartDAO.list(loggedInUserID);
			httpSession.setAttribute("cartList", cartList);
		for (Cart a:cartList) {
				cartDAO.delete(a.getId());
		}
			mv.addObject("orderPlacedMessage", "Your Order Placed Successfully...Continue Shopping");
			mv.addObject("clickedPlaceOrder",true);
		}
		else
		{
			mv.addObject("orderPlacedMessage", "Sorry, Your order is not Successfully Placed.. Try again after some time !!!");
		}
		return mv;
	}

}
