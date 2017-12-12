package com.niit.dao;

import java.util.List;

import com.niit.model.Productmodel;
public interface productmodeldao {
	public void saveProductmodel(Productmodel productmodel);
	public List<Productmodel>getproducts();
	public void delete(Productmodel productmodel);

	public Productmodel getProductDetail(int pid);
	public List<Productmodel> getproductsbycategoryid(int categoryid);
	public void update(Productmodel productmodel);
	public Productmodel findById(int id);

}


