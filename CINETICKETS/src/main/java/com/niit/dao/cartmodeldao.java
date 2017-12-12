package com.niit.dao;

import java.util.List;

import com.niit.model.CartModel;

public interface cartmodeldao {

		public void addToCart(CartModel cart);
		public boolean updateCart(CartModel cart);
		public boolean deleteCart(CartModel cart);
		public CartModel getCartItem(int cartItemId);
		public List<CartModel>getCartItems(String email);
		public Object getCartById(String userId);
		public List<CartModel> getAll();
		public CartModel getId(int cid);
		public CartModel getCartItem(int pid, String userId);
		
		
}