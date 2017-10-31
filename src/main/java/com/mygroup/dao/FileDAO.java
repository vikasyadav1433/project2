package com.mygroup.dao;

import com.mygroup.model.UploadFile;

public interface FileDAO {

	public abstract void uploadFile(UploadFile file);
	
	public abstract UploadFile getFile(String username);
}
