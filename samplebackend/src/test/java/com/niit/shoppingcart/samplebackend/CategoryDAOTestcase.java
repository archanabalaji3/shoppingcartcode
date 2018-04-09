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
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO= (CategoryDAO)context.getBean("categoryDAO");
		category= (Category)context.getBean("category");
	}
	
	@Test
	public void saveCategoryTestCase() {
		category.setCategory_id("cat005");
		category.setDescription("kk;l");
		category.setName(" gjvgy");
		categoryDAO.save(category);
		}

	@Test
	public void updateCategoryTestCase(){
		category.setCategory_id("cat005");
		category.setName("Cellphone");
		boolean status= categoryDAO.update(category);
		assertEquals("update category test case", true, status);
	}
	
	@Test
	public void getCategorySucceedsTestCase(){
		category= categoryDAO.get("cat004");
		assertNotNull("get Category Test Case", category);
	}
	@Test
	public void getCategoryFailsTestCase(){
		category= categoryDAO.get("Mob-003");
		assertNull("get Category Test Case fails", category);
	}
	
	@Test
	public void deleteCategorySucceedsTestCase(){
		boolean status= categoryDAO.delete("cat005");
		assertEquals("delete Category Test Case succeeds", true, status);
	}
	@Test
	public void deleteCategoryFailsTestCase(){
		boolean status= categoryDAO.delete("Mob-002");
		assertEquals("delete Category Test Case fails", false, status);
	}
	
	@Test
	public void getAllCategoryTestCase(){
		List<Category> categories= categoryDAO.list();
		assertEquals("get all categories", 5, categories.size());
	}
}
