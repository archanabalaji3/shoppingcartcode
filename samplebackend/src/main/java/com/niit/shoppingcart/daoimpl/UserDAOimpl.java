package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("userDAO")                          //Create instance UserDAOimpl
public class UserDAOimpl implements UserDAO {
	@Autowired 															//session factory will automatically inject in this class
	private SessionFactory sessionFactory;
	
	@Autowired
	private User user;
	
	Logger log= LoggerFactory.getLogger(UserDAOimpl.class);
	
	public boolean save(User user) {
																		//stores in the database
		log.debug("Starting of the save method");
		try{
			user.setRole('C');
			user.setRegisteredDate(new Date(System.currentTimeMillis()));
			
			sessionFactory.getCurrentSession().save(user);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		log.debug("Starting of the update method");
		try{
			sessionFactory.getCurrentSession().update(user);
			log.debug("Ending of the update method");
		return true;												//false
		} catch (HibernateException e){
			e.printStackTrace();
			log.error("Error occurred in update method"+ e.getMessage());
			return false;
		}
		
	}

	public User get(String emailId) { 								//based on emailId fetches the record & stores in User class
		return sessionFactory.getCurrentSession().get(User.class, emailId);
	}

	public boolean delete(String emailId) {
		log.debug("Starting of the delete method");
		try{
			user= get(emailId);								//?
			if(user==null){									//?
				return false;
			}
			sessionFactory.getCurrentSession().delete(user);
			log.debug("Ending of the delete method");
			return true;
		} 
		catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	public List<User> list() {
		log.debug("Starting of the list method");
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String emailId, String password){
																					//select * from user where emailId= 'jaskaran@gmail.com' and password='jas@123'
		log.debug("Starting of the validate method");
		log.info("user"+ emailId+ "trying to login");
		return (User)sessionFactory.getCurrentSession().createCriteria(User.class)
		.add(Restrictions.eq("emailID", emailId)).add(Restrictions.eq("pwd", password)).uniqueResult();
																					//emailID- from database, emailId- entered by user
	}
}	