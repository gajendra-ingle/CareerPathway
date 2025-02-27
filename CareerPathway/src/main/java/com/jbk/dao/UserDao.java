package com.jbk.dao;

import java.util.List;

import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;

public interface UserDao {

	public int createUser(User user);

	public int deleteUser(String userName);

	public List<User> allUsers();

	public User getUserByUsername(String userName);

	public User login(LoginRequest loginRequest);

	public int updateUser(User user);

}
