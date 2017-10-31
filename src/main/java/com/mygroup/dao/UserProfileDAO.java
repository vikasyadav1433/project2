package com.mygroup.dao;

import java.util.List;

import com.mygroup.model.UserProfile;


public interface UserProfileDAO {
	public abstract List<UserProfile> getProfiles();
}
