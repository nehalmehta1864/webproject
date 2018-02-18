package com.niit.daoimpl;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.dao.CartDao;
import com.niit.model.CartModel;
import com.niit.model.Productmodel;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public CartDaoImpl(SessionFactory sessionfactory)
	{
		this.sessionFactory=sessionfactory;
	}
	
	
	//for adding to cart
 public void addcart(CartModel cart)
 {
	 Session ssn=sessionFactory.openSession();
		Transaction t=ssn.getTransaction();
		t.begin();
		ssn.save(cart);
		t.commit();
		ssn.close();
	 
	 
	 
	 
 }
//getting the details of the product by id
public Productmodel getprodbyid(int id) {
	
		Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	Productmodel l = (Productmodel) ssn.get(Productmodel.class,id);
	
    t.commit();
    ssn.close();
   
	
	return l;
}

//getting cartitems by the name of the loginned user
public ArrayList<CartModel> getcartitemsbyname(String name) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	org.hibernate.Query q= ssn.createQuery("from Cart where username='"+name+"'");
	ArrayList<CartModel> l=(ArrayList<CartModel>) q.list();
	
    t.commit();
    ssn.close();
 
	
	return l;
}
//dor deleting a cart item  by id
public void deletecartitem(int cartid) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	CartModel l = (CartModel) ssn.get(CartModel.class, cartid);
	ssn.delete(l);
			
	
    t.commit();
    
    ssn.close();
	
}
//for getting a details of a cart item by id 
public CartModel getcartitembyid(String cartid) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	CartModel l = (CartModel) ssn.get(CartModel.class, cartid);
	
			
	
    t.commit();
    
    ssn.close();
    return l;
	
}

//for updating cartitem
public void updatecartitem(CartModel cart) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
ssn.update(cart);
	
    t.commit();
    
    ssn.close();
	
}
//if exixting product is added again the quantity incremented
public void updatequan(int imp, int i) {
	Session ssn=sessionFactory.openSession();
	Transaction t=ssn.getTransaction();
	t.begin();
	 Query qry1 = ssn.createQuery("update Cart  set quantity="+i+"where cartid="+imp);
	  
	 
			       
	
			          qry1.executeUpdate();
			         				
	
    t.commit();
    
    ssn.close();
	
}


}