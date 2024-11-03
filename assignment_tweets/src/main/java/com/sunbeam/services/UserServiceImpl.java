package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
	@Override
	public User findByEmail(String email) {
		User user=userDao.findByEmail(email);
		return user;
	}

}
