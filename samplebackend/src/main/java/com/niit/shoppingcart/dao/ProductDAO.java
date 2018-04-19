package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {
	
	public boolean save(Product product);        //save new product
	public boolean update(Product product);      //update existing product
	public Product get(String id);               //get particular product details based on id
	public boolean delete(String id);            //delete particular category
	public List<Product> list();                 //get product list
	
}
