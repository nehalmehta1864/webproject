package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Productmodel {
	@Id
	
	private int id;
	private String name;
    private String description;
    private String price;
    private int quantity;
    private String pImage;
   
    @ManyToOne
    @JoinColumn(name = "categoryId")
	private Category prodCategory;
    
	@ManyToOne
    @JoinColumn(name = "supplierId")
	private Supplier prodSupplier;
   
	

	
	
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public Productmodel()
	{
		
	}
	public Category getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(Category prodCategory) {
		this.prodCategory = prodCategory;
	}
	public Supplier getProdSupplier() {
		return prodSupplier;
	}
	public void setProdSupplier(Supplier prodSupplier) {
		this.prodSupplier = prodSupplier;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
