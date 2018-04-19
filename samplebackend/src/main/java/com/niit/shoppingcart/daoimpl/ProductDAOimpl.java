package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOimpl implements ProductDAO {
	@Autowired 
	private SessionFactory sessionFactory;

	@Autowired
	private Product product;

	public boolean save(Product product) {
		// store in the database.
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Product get(String emailID) {
		// it will fetch the record based on emailID and store in Product class
		return sessionFactory.getCurrentSession().get(Product.class, emailID);

	}

	public boolean delete(String emailID) {
		try {
			product = get(emailID);
			if (product == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(product);

			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<Product> list() {
	return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

}
