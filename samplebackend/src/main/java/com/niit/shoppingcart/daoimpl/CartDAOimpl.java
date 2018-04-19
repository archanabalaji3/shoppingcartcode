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
	private SessionFactory sessionFactory;

	@Autowired
	private Cart cart;

	public boolean save(Cart cart) {
		// store in the database.
		try {
			cart.setId();
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Cart get(int id) {
		// it will fetch the record based on id and store in Cart class
		return sessionFactory.getCurrentSession().get(Cart.class, id);

	}

	public boolean delete(int id) {
		String hql = "delete from Cart where id='" + id + "'";
		try {
			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Cart> list(String emailID) {
		// select * from cart where emialID = ?
		return sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("emailID", emailID))
				.list();

	}

	public boolean update(String emailID) {

		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCart(String emailID) {

		String hql = "delete from Cart where emailID='" + emailID + "'";
		try {
			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}