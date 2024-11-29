package com.jbk.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.UserDao;
import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;
import com.jbk.exceptions.ResourceNotFoundException;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int createUser(User user) {
		try (Session session = sessionFactory.openSession()) {
			User dbUser = session.get(User.class, user.getUsername());
			if (dbUser == null) {
				session.save(user);
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
	public int deleteUser(String userName) {
		try (Session session = sessionFactory.openSession()) {
			User user = session.get(User.class, userName);
			if (user != null) {
				session.delete(user);
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
	public List<User> allUsers() {
		List<User> userList = null;
		try (Session session = sessionFactory.openSession()) {
			String hql = "FROM User";
			Query<User> query = session.createQuery(hql, User.class);
			userList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUserByUsername(String userName) {
		User user = null;
		try (Session session = sessionFactory.openSession()) {
			user = session.get(User.class, userName);
			if (user != null) {
				return user;
			} else {
				throw new ResourceNotFoundException("User Not Exit.....");
			}
		}
	}

	@Override
	public User login(LoginRequest loginRequest) {
		try (Session session = sessionFactory.openSession()) {
			User user = session.get(User.class, loginRequest.getUserName());
			if (user != null) {
				if (user.getPassword().equals(loginRequest.getPassword())) {
					return user;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateUser(User user) {
		try (Session session = sessionFactory.openSession()) {

			User dbUser = session.get(User.class, user.getUsername());

			if (dbUser != null) {
				dbUser.setPassword(user.getPassword());
				dbUser.setQuestion(user.getQuestion());
				dbUser.setAnswer(user.getAnswer());

				session.update(dbUser);
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
