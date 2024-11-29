package com.jbk.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.StudentDao;
import com.jbk.entities.Student;
import com.jbk.exceptions.ResourceNotFoundException;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int registerStudent(Student student) {
		try (Session session = sessionFactory.openSession()) {
			Student dbStudent = session.get(Student.class, student.getId());
			if (dbStudent == null) {
				session.save(student);
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
	public List<Student> allStudents() {
		List<Student> studentList = null;
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM Student";
			Query<Student> query = session.createQuery(hql, Student.class);
			studentList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public int deleteStudentById(long id) {
		try (Session session = sessionFactory.openSession()) {
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student);
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
	public int updateStudent(Student student) {
		try (Session session = sessionFactory.openSession()) {
			Student dbStudent = session.get(Student.class, student.getId());
			if (dbStudent != null) {
				dbStudent.setEmail(student.getEmail());
				dbStudent.setPassword(student.getPassword());
				dbStudent.setContactNumber(student.getContactNumber());

				session.update(dbStudent);
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Student> getStudentByName(String name) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.eq("name", name));
		List<Student> student = criteria.list();

		if (!student.isEmpty()) {
			return student;
		} else {
			throw new ResourceNotFoundException("Student not exists for name=" + name);
		}

	}

	@Override
	public int registerMultipleStudent(List<Student> student) {
		try (Session session = sessionFactory.openSession()) {
			if (student != null && !student.isEmpty()) {
				for (Student std : student) {
					Student dbStudent = session.get(Student.class, std.getId());
					if (dbStudent == null) {
						session.save(std);
					}
				}
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
