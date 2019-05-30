package com.javawebspringboot.education.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javawebspringboot.education.model.User;

@Repository
@Transactional
public interface UserRepository  extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
