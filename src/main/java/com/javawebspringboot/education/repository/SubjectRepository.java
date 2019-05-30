package com.javawebspringboot.education.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javawebspringboot.education.model.Subject;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	Subject findByCodeSubject(String codeSubject);

	Subject findByIdSubject(Integer idSubject);
}
