package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.dao.suppliermodeldao;
import com.niit.model.Supplier;

public class supplierDaoImpl implements suppliermodeldao {

	@Autowired
	SessionFactory sessionFactory = null;

	public supplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public  void delete(Supplier supplier) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(supplier);
		session.getTransaction().commit();
		session.close();sessionFactory.openSession().delete(supplier);
		
	}

	

	public Supplier getsupplierbyid(int id)
	{
		Session session = sessionFactory.openSession();
		
 		session.beginTransaction();
 		Supplier supplier = session.get(Supplier.class,id);
		session.getTransaction().commit();
		return supplier;
	}

	public List<Supplier> getSupplier() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> supplierList = session.createQuery("from Supplier").list();
		session.getTransaction().commit();
		
		return supplierList;

	}



	public void savesupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(supplier);
		session.getTransaction().commit();
		
	}


/*	public Supplier findById(int parseInt) {
		{
			Session session = sessionFactory.openSession();
			
	 		session.beginTransaction();
	 		Supplier supplier = session.get(Supplier.class,parseInt);
			session.getTransaction().commit();
			return supplier;
	
	}*/

	}



