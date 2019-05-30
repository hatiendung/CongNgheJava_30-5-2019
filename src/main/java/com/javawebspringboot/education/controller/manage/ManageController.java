package com.javawebspringboot.education.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageController {

	@RequestMapping("/manage/")
	public String studentHomePage() {
		return "manage/home";
	}
}
