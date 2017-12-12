package com.niit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	private int categoryId;
	private String categoryName;

	@OneToMany(mappedBy = "prodCategory",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Productmodel> categoryProducts=new HashSet<Productmodel>(0);

	public Category()
	{
		
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Productmodel> getCategoryProducts() {
		return categoryProducts;
	}

	public void setCategoryProducts(Set<Productmodel> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}

}
