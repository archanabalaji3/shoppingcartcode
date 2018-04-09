package com.niit.shoppingcart.samplebackend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestcase {
private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static UserDAO userDAO;
	
	@Autowired
	private static User user;								
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO= (UserDAO)context.getBean("userDAO");
		user= (User)context.getBean("user");
	}
	
	@Test
	public void saveUserTestCase()
	{
		/*user.setEmailID("maya@gmail.com");
		user.setMobile("345678912");
		user.setFullname("maya");
		user.setPwd("maya123");
		boolean status= userDAO.save(user);
		assertEquals("save user test case", true, status);*/
		
		user.setEmailID("maya@gmail.com");
		user.setMobile("1234567890");
		user.setFullname("maya");
		user.setPwd("maya123");
		boolean status= userDAO.save(user);
		assertEquals("save user test case", true, status);
		
		
		
		
	}
	
	/*@Test
	public void updateUserTestCase()
	{
		user.setEmailID("maya@gmail.com");
		user.setMobile("111111111");
		boolean status= userDAO.update(user);
		assertEquals("update user test case", true, status); 					
	}
	
	@Test
	public void getUserSucceedsTestCase()
	{
		user= userDAO.get("priya@gmail.com");
		assertNotNull("get user test case", user);
	}
	@Test
	public void getUserFailsTestCase()
	{
		user= userDAO.get("jaya@gmail.com");
		assertNull("get user test case fails", user);
	}
	
	@Test
	public void deleteUserSucceedsTestCase()	
	{
		boolean status= userDAO.delete("maya@gmail.com");
		assertEquals("delete user success test case", true, status);
	}
	@Test
	public void deleteUserFailsTestCase()	
	{
		boolean status= userDAO.delete("mahesh2@gmail.com");
		assertEquals("delete user failure test case", false, status);
	}
	
	@Test
	public void getAllUsersTestCase()
	{
		List<User> users= userDAO.list();							//call userDAO by object
		assertEquals("get all users", 4, users.size());
	}

	
	@Test
	public void validateCredentialsTestCase()
	{
		user= userDAO.validate("jaskaran@gmail.com", "jas@123");
		assertNotNull("validate user test case", user);
	}*/
}
