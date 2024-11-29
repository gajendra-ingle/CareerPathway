package com.jbk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column(name = "name", nullable = false)
	@NotBlank(message = "Invalid Name")
	private String name;

	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Invalid email address")
	private String email;

	@Column(name = "password", nullable = false)
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be at least 8 characters long and include one uppercase letter, one lowercase letter, one number, and one special character.")
	private String password;

	@Column(name = "contact_number", nullable = false, unique = true)
	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be exactly 10 digits.")
	private String contactNumber;

	@Column(name = "department", nullable = false)
	@NotBlank(message = "Invalid Department")
	private String department;

	@Column(name = "graduation_year", nullable = false)
	@Pattern(regexp = "^\\d{4}$", message = "Passout year must be exactly 4 digits.")
	private String graduationYear;

	public Student() {
	}

	public Student(Long id, String name, String email, String password, String contactNumber, String department,
			String graduationYear) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.department = department;
		this.graduationYear = graduationYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contactNumber=" + contactNumber + ", department=" + department + ", graduationYear="
				+ graduationYear + "]";
	}

}
