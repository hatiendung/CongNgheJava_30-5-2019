package com.javawebspringboot.education.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javawebspringboot.education.model.TestSubject;

@Repository
@Transactional
public interface TestSubjectRepository extends JpaRepository<TestSubject, Integer> {

}
