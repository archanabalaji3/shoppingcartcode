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

	Logger log= LoggerFactory.getLogger(ProductDAOimpl.class);
	
	public boolean save(Product product) {
		log.debug("Starting of the save method");
		try {
			product.setDate_created(new Date(System.currentTimeMillis()));
			
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		log.debug("Starting of the update method");
		try {
			sessionFactory.getCurrentSession().update(product);
			log.debug("Ending of the update method");
			return false;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Product get(String product_id) {
		return sessionFactory.getCurrentSession().get(Product.class, product_id);
	}

	public List<Product> list() {
//		return sessionFactory.getCurrentSession().createQuery("from Product").list();
		log.debug("Starting and ending of the list method");
		return(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	public boolean delete(String product_id) {
		log.debug("Starting of the delete method");
		try{
			product= get(product_id);
			if (product== null){
				return false;
			}
			sessionFactory.getCurrentSession().delete(product);
			log.debug("Ending of the delete method");
			return true;
		}
		catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}
}
