package com.javawebspringboot.education.service;

import java.util.List;

import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.model.UserLearningOutcome;
import com.javawebspringboot.education.utiles.TableScore;

public interface UserLearningOutcomeService {

	
	List<UserLearningOutcome> findByUser(User user);
        
        void updateLearningOutcome(List<TableScore> tableScores, Integer idSubject);
	
}
