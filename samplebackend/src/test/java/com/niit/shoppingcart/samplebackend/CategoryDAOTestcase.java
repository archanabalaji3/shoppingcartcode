package com.niit.shoppingcart.samplebackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

public class CategoryDAOTestcase {
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit"); 
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category = (Category)context.getBean("category");
	}
	@Test
	public void saveCategoryTestCase()
	{
		category = new Category();
category.setId("cat3");
		category.setName("Kids");
		category.setDescription("This is Kids category");
	  boolean status = 	categoryDAO.save(category);
	  assertEquals("save category test case", true, status);
	}
	
	/*
	@Test
	public void updateCategoryTestCase()
	{
		category.setId(101);
		category.setName("Mobile");
		category.setDescription("This is new mobile category");
		boolean status = categoryDAO.update(category);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getCategorySuccessTestCase()
	{
		
	category= categoryDAO.get(101);
	
	assertNotNull("get category test case", category);
	}
	
	@Test
	public void getCategoryFailureTestCase()
	{
		
	category= categoryDAO.get(101);
	
	assertNull("get category test case", category);
	}
	
	@Test
	public void deleteCategorySuccessTestCase()
	{
	boolean status = categoryDAO.delete(102);
	assertEquals("delete category succss test case" , true, status);
	
	}
	
	@Test
	public void deleteCategoryFailureTestCase()
	{
	boolean status = categoryDAO.delete(103);
	assertEquals("delete category failure test case" , false, status);
	}
	
	@Test
	public void getAllCategorysTestCase()
	{
	List<Category> categorys = categoryDAO.list();
	assertEquals("get all usres " , 5, categorys.size() );
	}*/
}
