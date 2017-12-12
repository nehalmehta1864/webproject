package com.niit.dao;

import java.util.List;

import com.niit.model.Usermodel;

public interface usermodeldao {
	public boolean addUser(Usermodel user);
	public boolean deleteUser(Usermodel user);
	public Usermodel get(String email);
	public List<Usermodel> getAllUsers();
	public void persist(Usermodel user);
	public Usermodel getUserDetail(String userId);

}
