package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface suppliermodeldao {
	public void savesupplier(Supplier supplier);
	public void delete(Supplier supplier);
	public Supplier getsupplierbyid(int id);
	public List<Supplier> getSupplier();
/*	public Supplier findById(int parseInt);
*/

}

