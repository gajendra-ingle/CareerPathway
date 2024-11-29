package com.jbk.dao;

import java.util.List;

import com.jbk.entities.JobPosting;

public interface JobPostingDao {

	public int createJob(JobPosting jobPosting);

	public List<JobPosting> getAllJobs();

	public int deleteJobById(long id);

	public int updateJob(JobPosting jobPosting);
}
