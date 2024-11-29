package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.Student;
import com.jbk.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@PostMapping("/register")
	public String registerStudent(@RequestBody @Valid Student student) {
		int status = studentServiceImpl.registerStudent(student);
		switch (status) {
		case 1:
			return "Student added sussfully";
		case 2:
			return "Student already exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

	@GetMapping("/all-students")
	public List<Student> allStudents() {
		List<Student> allStudentList = studentServiceImpl.allStudents();
		return allStudentList;
	}

	@DeleteMapping("/delete-student/{id}")
	public String deleteStudentById(@PathVariable long id) {
		int result = studentServiceImpl.deleteStudentById(id);
		switch (result) {
		case 1:
			return "Student delete sussfully";
		case 2:
			return "Student not exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

	@PutMapping("/update-student")
	public String updateStudent(@RequestBody Student student) {
		int updateOrNot = studentServiceImpl.updateStudent(student);
		switch (updateOrNot) {
		case 1:
			return "Student update sussfully";
		case 2:
			return "Student not exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

	@GetMapping("/get-student")
	public List<Student> getStudentByName(@RequestParam String name) {
		List<Student> student = studentServiceImpl.getStudentByName(name);
		return student;
	}

	@PostMapping("/register-multiple-student")
	public String registerMultipleStudent(@RequestBody List<Student> student) {
		int status = studentServiceImpl.registerMultipleStudent(student);
		switch (status) {
		case 1:
			return "Student added sussfully";
		case 2:
			return "Student already exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

}
