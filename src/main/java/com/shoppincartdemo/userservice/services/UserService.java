package com.shoppincartdemo.userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppincartdemo.userservice.models.User;
import com.shoppincartdemo.userservice.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
