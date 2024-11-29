package com.jbk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.daoImpl.JobPostingDaoImpl;
import com.jbk.entities.JobPosting;
import com.jbk.service.JobPostingService;

@Service
public class JobPostingServiceImpl implements JobPostingService {

	@Autowired
	JobPostingDaoImpl jobPostingDaoImpl;

	@Override
	public int createJob(JobPosting jobPosting) {
		int status = jobPostingDaoImpl.createJob(jobPosting);
		return status;
	}

	@Override
	public List<JobPosting> getAllJobs() {
		List<JobPosting> jobList = jobPostingDaoImpl.getAllJobs();
		return jobList;
	}

	@Override
	public int deleteJobById(long id) {
		int deleteOrNot = jobPostingDaoImpl.deleteJobById(id);
		return deleteOrNot;
	}

	@Override
	public int updateJob(JobPosting jobPosting) {
		int updateOrNot = jobPostingDaoImpl.updateJob(jobPosting);
		return updateOrNot;
	}

}
