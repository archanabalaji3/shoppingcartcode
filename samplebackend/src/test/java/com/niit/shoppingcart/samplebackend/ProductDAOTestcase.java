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
	
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@Autowired
	private static Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit"); 
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		product = (Product)context.getBean("product");
	}
	/*@Test
	public void saveProductTestCase()
	{
		product = new Product();
		product.setId("p2");
		product.setName("AnalogWatch");
		product.setDescription("This is Fasttrack product");
		product.setCategoryId("cat1");
		
	  boolean status = 	productDAO.save(product);
	  
	  assertEquals("save product test case", true, status);
	}
	
	
	@Test
	public void updateProductTestCase()
	{
		product.setId("001");
		product.setName("Lenevo-prodcut");
		product.setDescription("This is Lenevo product");
		boolean status = productDAO.update(product);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getProductSuccessTestCase()
	{
		
	product= productDAO.get("001");
	
	assertNotNull("get product test case", product);
	}
	
	@Test
	public void getProductFailureTestCase()
	{
		
	product= productDAO.get("001");
	
	assertNull("get product test case", product);
	}*/
	
	@Test
	public void deleteProductSuccessTestCase()
	{
	boolean status =	productDAO.delete("p2");
	assertEquals("delete product succss test case" , true, status);
	
	}
	
	/*@Test
	public void deleteProductFailureTestCase()
	{
	boolean status = productDAO.delete("001");
	assertEquals("delete product failure test case" , false, status);
	}
	@Test
	public void getAllProductsTestCase()
	{
	List<Product>	products = productDAO.list();
	assertEquals("get all products " , 3, products.size() );
	}*/
}
