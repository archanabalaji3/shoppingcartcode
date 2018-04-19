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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;
@Transactional
@Repository("supplierDAO")
public class SupplierDAOimpl implements SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Supplier supplier;

	public boolean save(Supplier supplier) 
	{
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) 
	{
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Supplier get(String emailID) {
		return sessionFactory.getCurrentSession().get(Supplier.class, emailID);
	}

	public boolean delete(String emailID) {
		try {
			supplier = get(emailID);
			if (supplier == null) {
				return false;
			}
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Supplier> list() {
	return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}
}
