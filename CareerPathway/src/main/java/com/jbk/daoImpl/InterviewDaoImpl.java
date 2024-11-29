package com.jbk.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.InterviewDao;
import com.jbk.entities.Interview;

@Repository
public class InterviewDaoImpl implements InterviewDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int interviewSchedule(Interview interview) {
		try (Session session = sessionFactory.openSession()) {
			Interview dbInterview = session.get(Interview.class, interview.getId());
			if (dbInterview == null) {
				session.save(interview);
				session.beginTransaction().commit();
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public Object getInterviewById(long id) {
		try (Session session = sessionFactory.openSession()) {
			Interview dbInterview = session.get(Interview.class, id);
			if (dbInterview != null) {
				return dbInterview;
			} else {
				return "Not Exits";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Something Went Wrong";
		}
	}

	@Override
	public int updateInterviewStatus(long id, String status) {
		try (Session session = sessionFactory.openSession()) {
			Interview interview = session.get(Interview.class, id);
			if (interview != null) {
				interview.setInterviewStatus(status);
				session.update(interview);
				session.beginTransaction().commit();
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

}
