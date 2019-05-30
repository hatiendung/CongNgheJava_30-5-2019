package com.javawebspringboot.education.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.javawebspringboot.education.model.Role;
import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.repository.RoleRepository;
import com.javawebspringboot.education.repository.UserRepository;

@Component
public class WebUtil implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		for (int i = 0; i < 10; i++) {
//			User lecturer = new User();
//			String s = "lecturer" + (i+1);
//			lecturer.setUsername(s);
//			lecturer.setPassword(passwordEncoder.encode(s));
//			List<Role> roles = new ArrayList<>();
//			roles.add(roleRepository.findByName("ROLE_LECTURER"));
//			lecturer.setRoleList(roles);
//			userRepository.save(lecturer);
//		}
		
	}

}
