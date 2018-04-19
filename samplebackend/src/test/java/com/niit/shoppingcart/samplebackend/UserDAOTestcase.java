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
		context = new AnnotationConfigApplicationContext();
		//scan the complete package and check for annoations like
		//@Component, @Controller, @Repository, @Service
		context.scan("com.niit"); 
		//clear the context(bean factory, and recreate all the
		//instances of the classes which are there in com.niit
		//with proper annotations.
		context.refresh();
		//ask the context to get instance of UserDAO
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User)context.getBean("user");
	}
	@Test
	public void saveUserTestCase()
	{
		user = new User();
		user.setEmailID("maya@gmail.com");
		user.setName("Maya");
		user.setPwd("maya123");
		user.setMobile("3333333333");
		user.setRegisteredDate("");
   	  boolean status = 	userDAO.save(user);
	  assertEquals("save user test case", true, status);
	}
	
	
	/*@Test
	public void updateUserTestCase()
	{
		user.setEmailID("mike@gmail.com");
		user.setMobile("626262626");
		boolean status = userDAO.update(user);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getUserSuccessTestCase()
	{
		
	user= userDAO.get("mike@gmail.com");
	
	assertNotNull("get user test case", user);
	}
	
	@Test
	public void getUserFailureTestCase()
	{
		
	user= userDAO.get("ji@gmail.com");
	
	assertNull("get user test case", user);
	}
	
	@Test
	public void deleteUserSuccessTestCase()
	{
	boolean status =	userDAO.delete("mickkey@gmail.com");
	assertEquals("delete user succss test case" , true, status);
	
	}
	
	@Test
	public void deleteUserFailureTestCase()
	{
	boolean status =	userDAO.delete("ae@gmail.com");
	assertEquals("delete user failure test case" , false, status);
	
	}
	
	
	@Test
	public void getAllUsersTestCase()
	{
	List<User>	users = userDAO.list();
	
	assertEquals("get all usres " , 3, users.size() );
	
	}
	@Test
	public void validateCredentailsTestCase()
	{
	user = 	userDAO.validate("aulrin@gmail.com","aul@123");
	assertNotNull("Validate test case",user );
	
	}*/
}
