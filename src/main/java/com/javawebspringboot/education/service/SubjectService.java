package com.javawebspringboot.education.service;

import com.javawebspringboot.education.exception.ReadFileException;
import org.springframework.web.multipart.MultipartFile;

import com.javawebspringboot.education.model.Subject;

public interface SubjectService {
	
	Subject findByIdSubject(Integer idSubject);
	
	boolean fileHandler( MultipartFile fileExcel) throws ReadFileException;
}
