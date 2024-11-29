package com.jbk.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.JobPostingDao;
import com.jbk.entities.JobPosting;

@Repository
public class JobPostingDaoImpl implements JobPostingDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int createJob(JobPosting jobPosting) {
		try (Session session = sessionFactory.openSession()) {
			JobPosting dbJobPost = session.get(JobPosting.class, jobPosting.getId());
			if (dbJobPost == null) {
				session.save(jobPosting);
				session.beginTransaction().commit();
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			return 3;
		}
	}

	@Override
	public List<JobPosting> getAllJobs() {
		List<JobPosting> jobList = null;
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM JobPosting";
			Query<JobPosting> jobs = session.createQuery(hql, JobPosting.class);
			jobList = jobs.getResultList();
			return jobList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobList;
	}

	@Override
	public int deleteJobById(long id) {
		try (Session session = sessionFactory.openSession()) {
			JobPosting jobPosting = session.get(JobPosting.class, id);
			if (jobPosting != null) {
				session.delete(jobPosting);
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
	public int updateJob(JobPosting jobPosting) {
		try (Session session = sessionFactory.openSession()) {
			JobPosting dbJobPosting = session.get(JobPosting.class, jobPosting.getId());
			if (dbJobPosting != null) {

				dbJobPosting.setJobTitle(jobPosting.getJobTitle());
				dbJobPosting.setCompanyName(jobPosting.getCompanyName());
				dbJobPosting.setJobDescription(jobPosting.getJobDescription());
				dbJobPosting.setJobLocation(jobPosting.getJobLocation());
				dbJobPosting.setEligibilityCriteria(jobPosting.getEligibilityCriteria());

				session.update(dbJobPosting);
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
