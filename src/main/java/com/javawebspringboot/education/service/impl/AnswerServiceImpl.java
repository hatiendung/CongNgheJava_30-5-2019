package com.javawebspringboot.education.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javawebspringboot.education.model.Answer;
import com.javawebspringboot.education.model.Subject;
import com.javawebspringboot.education.repository.AnswerRepository;
import com.javawebspringboot.education.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public List<Answer> findBySubjectAndIdKithi(Subject subject, Integer idKithi) {
		// TODO Auto-generated method stub
		return answerRepository.findBySubjectAndIdKithiOrderBySttAnswer(subject, idKithi);
	}

}
