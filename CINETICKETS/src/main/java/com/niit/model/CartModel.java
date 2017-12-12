package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartModel {
	@Id
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int cartItemId;

    private int productId;
	private int quantity;
	private String pname;

    private double price;
	
	private String cartImage;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="u_mail")
	private Usermodel CartUserDetails;
    
    
	
	
	
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}



	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}

	public Usermodel getCartUserDetails() {
		return CartUserDetails;
	}

	public void setCartUserDetails(Usermodel cartUserDetails) {
		CartUserDetails = cartUserDetails;
	}



	

	



	

}