/**
 * 
 */
package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;

/**
 * @author WM87
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findByUsername(String username) {
		System.out.println("Calling this UserService 111111111111111111111111111111 ");
		User user = userDao.findByUsername(username);
		System.out.println("Calling this UserService 111111111111111111111111111111 ");
		return user;
	}

	public void createUser(User user) {
		userDao.add(user);
	}

}
