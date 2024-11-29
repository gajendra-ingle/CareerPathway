package com.jbk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.daoImpl.StudentDaoImpl;
import com.jbk.entities.Student;
import com.jbk.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDaoImpl studentDaoImpl;

	@Override
	public int registerStudent(Student student) {
		int status = studentDaoImpl.registerStudent(student);
		return status;
	}

	@Override
	public List<Student> allStudents() {
		List<Student> studentList = studentDaoImpl.allStudents();
		return studentList;
	}

	@Override
	public int deleteStudentById(long id) {
		int deleteOrNot = studentDaoImpl.deleteStudentById(id);
		return deleteOrNot;
	}

	@Override
	public int updateStudent(Student student) {
		int updateOrNot = studentDaoImpl.updateStudent(student);
		return updateOrNot;
	}

	@Override
	public List<Student> getStudentByName(String name) {
		List<Student> student = studentDaoImpl.getStudentByName(name);
		return student;
	}

	public int registerMultipleStudent(List<Student> student) {
		int ans = studentDaoImpl.registerMultipleStudent(student);
		return ans;
	}

}
