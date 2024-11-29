package com.jbk.dao;

import com.jbk.entities.JobApplication;

public interface JobApplicationDao {

	public int applayForJob(JobApplication jobApplication);
	
	public int updateJobStatus(long id,String status);
}
