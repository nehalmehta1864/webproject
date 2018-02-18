package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.dao.usermodeldao;

import com.niit.model.Usermodel;

@Repository("UserDao")
public class usermodeldaoimpl implements usermodeldao {
	
	

	private static final List<Usermodel> UsermodelList = null;
	private SessionFactory sessionFactory;
	public usermodeldaoimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

	public boolean addUser(Usermodel user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		return false;
	}

	public boolean deleteUser(Usermodel user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		
		return false;
	}

	public Usermodel get(int userId) {
		
		{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Usermodel usermodel= (Usermodel) session.get(Usermodel.class, new Integer(userId));
			session.getTransaction().commit();
			session.close();
			return usermodel;		
			 
		}

	}
	
	

	public List<Usermodel> getAllUsers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Usermodel>usermodelList = session.createQuery("from Usermodel").list();
		session.getTransaction().commit();
		session.close();
		return usermodelList;
	
	}



	public void persist(Usermodel user) {
		
		
	}



	public Usermodel getUserDetail(int userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Usermodel usermodel = (Usermodel) session.get(Usermodel.class, userId);
		
	
		session.getTransaction().commit();
		session.close();
		return usermodel;
	
	}



	public Usermodel get(String userId) {
		// TODO Auto-generated method stub
		return null;
	}



	public Usermodel getUserDetail(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


/*
	public Usermodel getUserDetail(String userId) {
		// TODO Auto-generated method stub
		return null;
	}*/


/*
	public Usermodel getUserDetail(String userId) {
		// TODO Auto-generated method stub
		return null;
	}



	public Usermodel get(String userId) {
		// TODO Auto-generated method stub
		return null;
	}*/



	




	
}