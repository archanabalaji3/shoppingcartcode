package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

@Transactional
@Repository("cartDAO")
public class CartDAOimpl implements CartDAO {

	@Autowired
	private Cart cart;

	@Autowired
	private SessionFactory sessionFactory;

	Logger log= LoggerFactory.getLogger(CartDAOimpl.class);
	
	public boolean save(Cart cart) {
		log.debug("Starting of the save method");
		try {
			sessionFactory.getCurrentSession().save(cart);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Cart cart) {
		log.debug("Starting of the update method");
		try {
			sessionFactory.getCurrentSession().update(cart);
			log.debug("Ending of the update method");
			return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Cart get(String cart_id) {
		return sessionFactory.getCurrentSession().get(Cart.class, cart_id);
	}

	@SuppressWarnings("unchecked")
	public List<Cart> list(String emailid) {
		log.debug("Starting of the list method");
		return (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.add(Restrictions.eq("emailid", "emailid")).list();
	}

	public boolean delete(String id) {
		log.debug("Starting of the delete method");
		try{
			cart= get(id);
			if (cart== null){
				return false;}
			else
			{sessionFactory.getCurrentSession().delete(cart);
			log.debug("Ending of the delete method");
			return true;}
		} 
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}
	
}
