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
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.User;
import com.jbk.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/create-user")
	public String createUser(@RequestBody @Valid User user) {
		int status = userServiceImpl.createUser(user);
		switch (status) {
		case 1:
			return "User added sussfully";
		case 2:
			return "User already exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

	@DeleteMapping("/delete-user/{username}")
	public String deleteUser(@PathVariable(name = "username") String userName) {
		int status = userServiceImpl.deleteUser(userName);
		switch (status) {
		case 1:
			return "User delete sussfully";
		case 2:
			return "User not exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

	@GetMapping("/all-users")
	public List<User> allUsers() {
		return userServiceImpl.allUsers();
	}

	@GetMapping("/get-user/{username}")
	public Object getUserByUsername(@PathVariable(name = "username") String userName) {
		User user = userServiceImpl.getUserByUsername(userName);
		if (user != null) {
			return user;
		} else {
			return "User not found for username = " + userName;
		}
	}

	@PutMapping("/update-user")
	public String updateUser(@RequestBody User user) {
		int result = userServiceImpl.updateUser(user);
		switch (result) {
		case 1:
			return "User update sussfully";
		case 2:
			return "User not exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

}
