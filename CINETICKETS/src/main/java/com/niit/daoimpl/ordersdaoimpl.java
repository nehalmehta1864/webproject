package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.dao.ordersdao;
import com.niit.model.Category;
import com.niit.model.Orders;
import com.niit.model.Productmodel;
import com.niit.model.Usermodel;

public class ordersdaoimpl implements ordersdao{
	private SessionFactory sessionFactory;
	public ordersdaoimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean add (Orders orders) {
		Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.persist(orders);
	session.getTransaction().commit();
	return false;
	
		
	}

	public void update(Orders orders) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(orders);
		session.getTransaction().commit();
		session.close();
	}

	public Usermodel findById(int id) {
		return (Usermodel)sessionFactory.openSession().get(Usermodel.class,id);
		
	}

	public void delete(Orders orders) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.delete(orders);
		session.getTransaction().commit();
		session.close();
		
	}

	public List<Orders> getAllOrders() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Orders>getAllOrders = session.createQuery("from orders").list();
		session.getTransaction().commit();
		session.close();
		return getAllOrders();
		
	}


}
