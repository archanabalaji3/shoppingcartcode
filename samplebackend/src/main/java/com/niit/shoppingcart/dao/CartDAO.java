package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Cart;


public interface CartDAO {
	
    public boolean save(Cart cart);
	public boolean update(Cart cart);
	public Cart get(String id);
	public List<Cart> list(String emailid);
	public boolean delete(String id);
	
}
