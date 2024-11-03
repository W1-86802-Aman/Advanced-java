package com.sunbeam.services;

import com.sunbeam.entities.User;

public interface UserService {

	User findByEmail(String email);

}
