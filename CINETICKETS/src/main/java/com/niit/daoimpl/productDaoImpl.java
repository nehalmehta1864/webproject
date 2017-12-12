package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.productmodeldao;
import com.niit.model.Productmodel;

public class productDaoImpl implements productmodeldao {

	@Autowired
	SessionFactory sessionFactory = null;

	public productDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveProductmodel(Productmodel productmodel) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(productmodel);
		session.getTransaction().commit();
	}

	public List<Productmodel> getproducts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Productmodel>productmodelList = session.createQuery("from Productmodel").list();
		session.getTransaction().commit();
		session.close();
		return productmodelList;
	}

	public void delete(Productmodel productmodel) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(productmodel);
		session.getTransaction().commit();
		session.close();
		
	}
	
	

	
	public Productmodel getProductDetail(int pid)
 {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Productmodel product = (Productmodel) session.get(Productmodel.class, pid);
		
	
		session.getTransaction().commit();
		session.close();
		return product;
	}
	

	public List<Productmodel> getproductsbycategoryid(int categoryid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Productmodel> categorylistid = session.createQuery("from Productmodel where categoryid = "+categoryid).list();
		session.getTransaction().commit();
	
		return categorylistid;
	}

	public void update(Productmodel productmodel) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(productmodel);
		session.getTransaction().commit();
		session.close();
		
	}

	public Productmodel findById(int id) {
		return (Productmodel)sessionFactory.openSession().get(Productmodel.class,id);
	}
	

	
	}


	

	

	

	

	


