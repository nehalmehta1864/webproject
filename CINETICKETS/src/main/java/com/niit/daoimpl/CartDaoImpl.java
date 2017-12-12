package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.cartmodeldao;
import com.niit.model.CartModel;

@SuppressWarnings("deprecation")
@Repository("cartDao")
public class CartDaoImpl implements cartmodeldao {
	@Autowired
	
	
	private SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	


	@Transactional
	public boolean updateCart(CartModel cart) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (Exception e) {
			System.out.println("Exception arised" + e);

		}
		return false;

	}
	
	
	@Transactional
	public boolean deleteCart(CartModel cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			System.out.println("Exception arised" + e);

		}
		return false;
	}

	
	@Transactional
	public CartModel getCartItem(int cartItemId) {
		Session session = sessionFactory.openSession();
		CartModel cart = (CartModel) session.get(CartModel.class, new Integer(cartItemId));
		/* sessionFactory.getCurrentSession().get(Product.class,id); */
		return cart;
	}

	
	@Transactional
	public List<CartModel> getCartItems(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Cart where email=:email");
		query.setParameter("email", email);
		@SuppressWarnings("unchecked")
		List<CartModel> list = query.list();
		return list;
	}

	
	
	public void addToCart(CartModel cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
	}





	public Object getCartById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}





	public List<CartModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}





	public CartModel getId(int cid) {
		// TODO Auto-generated method stub
		return null;
	}





	public CartModel getCartItem(int pid, String userId) {
		// TODO Auto-generated method stub
		return null;
	}


	

}