package com.javawebspringboot.education.service;

import java.util.List;

import com.javawebspringboot.education.model.Scores;
import com.javawebspringboot.education.model.Subject;
import com.javawebspringboot.education.model.User;

public interface ScoresService {

	List<Scores> findByUser(User user);
	
	List<Scores> findBySubject(Subject subject);
        
}
