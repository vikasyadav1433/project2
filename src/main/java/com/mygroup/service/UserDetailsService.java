package com.mygroup.service;

import java.util.List;

import com.mygroup.model.UserDetails;



public interface UserDetailsService {
	public abstract List<UserDetails> getUsers();
	public abstract UserDetails getUserById(String uid);
	public abstract void addUser(UserDetails ud);

	public abstract UserDetails updateUser(String uid,UserDetails ud);
	public abstract void deleteUser(String uid);
	public abstract UserDetails logincheck(UserDetails ud);
	public abstract UserDetails registerUser(UserDetails ud);
	public abstract void updateUser1(UserDetails ud);
}
