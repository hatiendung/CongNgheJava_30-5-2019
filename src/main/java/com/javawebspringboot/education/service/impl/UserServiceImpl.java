package com.javawebspringboot.education.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.repository.UserRepository;
import com.javawebspringboot.education.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
