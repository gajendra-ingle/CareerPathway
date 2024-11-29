package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;
import com.jbk.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	UserServiceImpl userServiceImpl;

	
	@PostMapping("/login")
	public Object login(@RequestBody LoginRequest loginRequest) {

		User user = userServiceImpl.login(loginRequest);

		if (user != null) {
			return user;
		} else {
			return "Invalid Username and Password";
		}

	}

}
