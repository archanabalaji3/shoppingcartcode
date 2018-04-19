package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.domain.Supplier;

public interface SupplierDAO {
	
    public boolean save(Supplier supplier);      //save new supplier
	public boolean update(Supplier supplier);    //update existing supplier
	public Supplier get(String id);              //get particular supplier
	public boolean delete(String id);            //delete particular supplier
	public List<Supplier> list();                //get supplier list
} 
