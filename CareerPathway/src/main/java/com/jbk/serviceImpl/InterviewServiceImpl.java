package com.jbk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.daoImpl.InterviewDaoImpl;
import com.jbk.entities.Interview;
import com.jbk.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	InterviewDaoImpl interviewDaoImpl;

	@Override
	public int interviewSchedule(Interview interview) {
		int status = interviewDaoImpl.interviewSchedule(interview);
		return status;
	}

	@Override
	public Object getInterviewById(long id) {
		Object obj = interviewDaoImpl.getInterviewById(id);
		return obj;
	}

	@Override
	public int updateInterviewStatus(long id, String status) {
		int updatedStatus = interviewDaoImpl.updateInterviewStatus(id, status);
		return updatedStatus;
	}

}
