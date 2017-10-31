package com.mygroup.dao;

import java.util.List;

import com.mygroup.model.UserDetails;


public interface UserDetailsDAO {
	public abstract List<UserDetails> getUsers();
	public abstract UserDetails getUserById(String uid);
	public abstract void addUser(UserDetails ud);
	
	public abstract UserDetails updateUser(String uid,UserDetails ud);
	
	public abstract void deleteUser(String uid);
	
	public abstract UserDetails logincheck(UserDetails ud);
	
	public abstract UserDetails registerUser(UserDetails ud);
	
	public abstract UserDetails updateUser1(UserDetails ud);
	
	public abstract boolean saveImage();
	
}
