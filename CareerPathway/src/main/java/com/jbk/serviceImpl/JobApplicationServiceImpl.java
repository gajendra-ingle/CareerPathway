package com.jbk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.daoImpl.JobApplicationDaoImpl;
import com.jbk.entities.JobApplication;
import com.jbk.service.JobApplicationService;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

	@Autowired
	JobApplicationDaoImpl jobApplicationDaoImpl;

	@Override
	public int applayForJob(JobApplication jobApplication) {
		int status = jobApplicationDaoImpl.applayForJob(jobApplication);
		return status;
	}

	@Override
	public int updateJobStatus(long id, String status) {
		int updateStatus = jobApplicationDaoImpl.updateJobStatus(id, status);
		return updateStatus;
	}
}
