package com.javawebspringboot.education.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawebspringboot.education.model.Scores;
import com.javawebspringboot.education.model.Subject;
import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.repository.ScoresRepository;
import com.javawebspringboot.education.service.ScoresService;

@Service
public class ScoresServiceImpl implements ScoresService {

    @Autowired
    private ScoresRepository scoresRepository;

    @Override
    public List<Scores> findByUser(User user) {
        return scoresRepository.findByUser(user);
    }

	@Override
	public List<Scores> findBySubject(Subject subject) {
		return scoresRepository.findByMonhoc(subject);
	}

   

}
