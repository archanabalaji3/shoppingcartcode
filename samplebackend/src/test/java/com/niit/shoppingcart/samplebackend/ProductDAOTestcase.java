package com.niit.shoppingcart.samplebackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductDAOTestcase {
	
	@Autowired
	private static ProductDAO productDAO;
	
	@Autowired
	private static Product product;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO= (ProductDAO)context.getBean("productDAO");
		product= (Product)context.getBean("product");
	}
	
	@Test
	public void saveProductTestCase() {
		product.setProduct_id("p3");
		product.setName("Handbag");
		product.setPrice(3000);
		productDAO.save(product);
//		product.setCategory();
//		product.setSupplier(supplier);
		
		
	}

	@Test
	public void updateProductTestCase(){
		product.setProduct_id("p2");
		product.setPrice(2200);
		boolean status= productDAO.update(product);
		assertEquals("Successfully updated", true, status);
	}
	
	@Test
	public void getProductSucceedsTestCase(){
		product= productDAO.get("02");
		assertNotNull("get product test case", product);
	}
	@Test
	public void getProductFailsTestCase(){
		product= productDAO.get("04");
		assertNull("get product test case fails", product);
	}
	
	@Test
	public void deleteProductSucceedsTestCase(){
		boolean status= productDAO.delete("02");
		assertEquals("Successfully deleted", true, status); 
	}
	@Test
	public void deleteProductFailsTestCase(){
		boolean status= productDAO.delete("06");
		assertEquals("Unsuccessfully deleted", false, status); 
	}
	
	@Test
	public void getAllProductTestCase(){
		List<Product> products= productDAO.list();
		assertEquals("get all products", 1, products.size());
	}

}
