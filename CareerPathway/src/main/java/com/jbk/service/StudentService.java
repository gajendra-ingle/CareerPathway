package com.jbk.service;

import java.util.List;

import com.jbk.entities.Student;

public interface StudentService {

	public int registerStudent(Student student);

	public List<Student> allStudents();

	public int deleteStudentById(long id);

	public int updateStudent(Student student);
	
	public List<Student> getStudentByName(String name);
	
	public int registerMultipleStudent(List<Student> student);
	
	
}
