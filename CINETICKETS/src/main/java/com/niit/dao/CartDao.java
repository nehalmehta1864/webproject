package com.niit.dao;

import java.util.ArrayList;

import com.niit.model.CartModel;
import com.niit.model.Productmodel;

public interface CartDao {

	
	 public void addcart(CartModel cart);
	 public Productmodel getprodbyid(int id);
	 public ArrayList<CartModel> getcartitemsbyname(String name) ;
	 public void deletecartitem(int cartid);
	 public CartModel getcartitembyid(String userId);
	 public void updatecartitem(CartModel cart);
	 public void updatequan(int imp, int i) ;
}