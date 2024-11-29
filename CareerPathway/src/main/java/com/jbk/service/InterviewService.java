package com.jbk.service;

import com.jbk.entities.Interview;

public interface InterviewService {

	public int interviewSchedule(Interview interview);

	public Object getInterviewById(long id);

	public int updateInterviewStatus(long id, String status);
}
