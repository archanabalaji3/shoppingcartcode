package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {
	
	public boolean save(Category category);       //Save category
	public boolean update(Category category);     //update the existing category
	public Category get(String id);               //get particular category
	public boolean delete(String id);             //delete particular category
	public List<Category> list();                 //get all categories
	 
}
