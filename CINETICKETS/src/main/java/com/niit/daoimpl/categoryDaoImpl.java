package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.categorydao;
import com.niit.model.Category;

public class categoryDaoImpl implements categorydao {

	@Autowired
	SessionFactory sessionFactory = null;

	public categoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void savecategory(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(category);
		session.getTransaction().commit();
	}

	public List<Category> getCategories() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Category> categoryList = session.createQuery("from Category").list();
		session.getTransaction().commit();
		
		return categoryList;

	}

	public boolean delete(Category category) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(category);
		session.getTransaction().commit();
		session.close();sessionFactory.openSession().delete(category);
		return false;
	}

	

	public Category getcategorybyid(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category Category = session.get(Category.class,id);
		session.getTransaction().commit();
		return Category;
	}

/*	public Category findById(int parseInt) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category Category = session.get(Category.class,parseInt);
		session.getTransaction().commit();
		return Category;
	}*/


	

	}

	


