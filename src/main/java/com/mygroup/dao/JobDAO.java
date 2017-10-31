package com.mygroup.dao;

import java.util.List;

import com.mygroup.model.Job;


public interface JobDAO {

	public abstract void postJob(Job job);
	public abstract List<Job> getAllJobs();
}
