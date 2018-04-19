package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.domain.Cart;

public interface CartDAO {
	
    public boolean save(Cart cart);            //save product to cart
    public boolean update(Cart cart);          //update cart
	public boolean update(String emailID);     //update cart based on emailid
	public Cart get(int id);                   // get cart details based on cart id
	public boolean delete(int id);             //delete cart based on cart id
	public List<Cart> list(String emailID);    //get all cart list for particular user based on their id
	public boolean deleteCart(String emailID); // delete all cart items which added by particular user
}
