package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	private int id;
	private String paymentmode;
	private int total;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private Usermodel userdetails;

	public Usermodel getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Usermodel userdetails) {
		this.userdetails = userdetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
