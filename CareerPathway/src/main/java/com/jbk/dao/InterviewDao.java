package com.jbk.dao;

import com.jbk.entities.Interview;

public interface InterviewDao {

	public int interviewSchedule(Interview interview);
	
	public Object getInterviewById(long id);
	
	public int updateInterviewStatus(long id, String status);
}
