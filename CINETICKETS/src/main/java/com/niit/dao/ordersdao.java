package com.niit.dao;

import java.util.List;

import com.niit.model.Orders;
import com.niit.model.Usermodel;

public interface ordersdao {

	 public boolean add(Orders orders);
		
		public void update(Orders orders);
		
		public Usermodel  findById(int id);
		
		public void delete(Orders orders);
		
		public List<Orders> getAllOrders();
		
	

}
