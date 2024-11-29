package com.jbk.service;

import com.jbk.entities.JobApplication;

public interface JobApplicationService {
	public int applayForJob(JobApplication jobApplication);

	public int updateJobStatus(long id, String status);
}
