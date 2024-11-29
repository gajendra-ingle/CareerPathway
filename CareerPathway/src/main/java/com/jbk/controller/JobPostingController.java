package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.JobPosting;
import com.jbk.serviceImpl.JobPostingServiceImpl;

@RestController
@RequestMapping("/job-postings")
public class JobPostingController {

	@Autowired
	JobPostingServiceImpl jobPostingServiceImpl;

	@PostMapping("/create-job")
	public String createJob(@RequestBody JobPosting jobPosting) {
		int status = jobPostingServiceImpl.createJob(jobPosting);
		switch (status) {
		case 1:
			return "Job Posted Sussfully";
		case 2:
			return "Job Post Already Exist";
		case 3:
			return "Something went Wrong";
		default:
			return "";
		}
	}

	@GetMapping("/all-jobs")
	public List<JobPosting> getAllJobs() {
		List<JobPosting> jobList = jobPostingServiceImpl.getAllJobs();
		return jobList;
	}

	@DeleteMapping("/delete-job/{id}")
	public String deleteJobById(@PathVariable long id) {
		int status = jobPostingServiceImpl.deleteJobById(id);
		switch (status) {
		case 1:
			return "Job delete Sussfully";
		case 2:
			return "Job not exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

	@PutMapping("/update-job")
	public String updateJob(@RequestBody JobPosting jobPosting) {
		int updateResult = jobPostingServiceImpl.updateJob(jobPosting);
		switch (updateResult) {
		case 1:
			return "Job update Sussfully";
		case 2:
			return "Job not exit to update";
		case 3:
			return "Something went Wrong";
		default:
			return "";
		}
	}
}
