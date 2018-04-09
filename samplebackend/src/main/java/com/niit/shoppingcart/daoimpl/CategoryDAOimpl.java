package com.niit.shoppingcart.daoimpl;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {
	@Autowired
	private Category category;
	
	@Autowired
	private SessionFactory sessionFactory;

	Logger log= LoggerFactory.getLogger(CategoryDAOimpl.class);
	
	public boolean save(Category category) {
		log.debug("Starting of the save method");
		try{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		log.debug("Ending of the save method");
		return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {
		log.debug("Starting of the save method");
		try{
		sessionFactory.getCurrentSession().update(category);
		log.debug("Ending of the update method");
		return false;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	public Category get(String category_id) {
		return sessionFactory.getCurrentSession().get(Category.class, category_id);
	}

	public List<Category> list() {
		//return sessionFactory.getCurrentSession().createQuery("from Category").list();
		log.debug("List method");
		return(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	public boolean delete(String category_id) {
		log.debug("Starting of the delete method");
		try{
			category= get(category_id);
			if (category== null){
				return false;
			}
			sessionFactory.getCurrentSession().delete(category);
			log.debug("Ending of the delete method");
			return true;
		} 
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}	

}
