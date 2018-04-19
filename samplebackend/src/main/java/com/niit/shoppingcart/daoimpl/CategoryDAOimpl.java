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
	private SessionFactory sessionFactory;
	@Autowired
	private Category category;

	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Category get(String id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);

	}

	public boolean delete(String id) {
		try {
			category = get(id);
			if (category == null) {
				return false;
			}
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Category> list() {
		return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
}
