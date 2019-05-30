package com.javawebspringboot.education.service;

import com.javawebspringboot.education.model.User;

public interface UserService {
	User findByUsername(String username);
}
