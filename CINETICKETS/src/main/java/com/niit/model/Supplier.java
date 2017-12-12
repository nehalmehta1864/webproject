package com.niit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier {
	@Id
	private int supplierId;
	private String supplierName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prodSupplier")
	private Set<Productmodel> supplierproducts = new HashSet<Productmodel>(0);

	public Supplier() {

	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Set<Productmodel> getSupplierproducts() {
		return supplierproducts;
	}

	public void setSupplierproducts(Set<Productmodel> supplierproducts) {
		this.supplierproducts = supplierproducts;
	}

}
