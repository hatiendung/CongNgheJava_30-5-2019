package com.javawebspringboot.education.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javawebspringboot.education.model.Scores;
import com.javawebspringboot.education.model.Subject;
import com.javawebspringboot.education.model.User;

@Repository
@Transactional
public interface ScoresRepository extends JpaRepository<Scores, Integer> {

	List<Scores> findByUser(User user);
	
	List<Scores> findByMonhoc(Subject monhoc);
	
	Scores findByUserAndMonhoc(User user, Subject monhoc);

}
