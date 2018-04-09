package com.niit.shoppingcart.samplebackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierDAOTestcase {
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplier= (Supplier)context.getBean("supplier");
		supplierDAO= (SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	public void saveSupplierTestCase() {
		supplier.setSupplier_id("sup-03");
		supplier.setName("Supplier3");
		supplier.setAddress("Chennai");
		supplierDAO.save(supplier);
		}

	@Test
	public void updateSupplierTestCase(){
		supplier.setSupplier_id("sup-07");
		supplier.setName("Retail.net");
		supplier.setAddress("NH-33");
		boolean status= supplierDAO.update(supplier);
		assertEquals("Successfully updated", true, status);
	}
	
	@Test
	public void getSupplierTestCaseSuccess(){
		supplier= supplierDAO.get("02");
		assertNotNull("getting supplier test case", supplier);
	}
	@Test
	public void getSupplierTestCaseFail(){
		supplier= supplierDAO.get("08");
		assertNull("getting supplier test case fails", supplier);
	}
	
	@Test
	public void deleteSupplierTestCaseSuccess(){
		boolean status= supplierDAO.delete("06");
		assertEquals("Deleted properly", true, status);
	}
	@Test
	public void deleteSupplierTestCaseFail(){
		boolean status= supplierDAO.delete("06");
		assertEquals("Not deleted", false, status);
	}
	
	@Test
	public void getAllSuppliersTestCase(){
		List<Supplier> suppliers= supplierDAO.list();
		assertEquals("list of all suppliers", 2, suppliers.size());
	}
}
