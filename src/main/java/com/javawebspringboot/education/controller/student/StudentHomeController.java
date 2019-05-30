package com.javawebspringboot.education.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javawebspringboot.education.model.Subject;
import com.javawebspringboot.education.model.User;
import com.javawebspringboot.education.service.ScoresService;
import com.javawebspringboot.education.service.SubjectService;
import com.javawebspringboot.education.service.UserService;
import com.javawebspringboot.education.service.UserSubjectCoursesGoalService;

@Controller
public class StudentHomeController {

	@Autowired
	private UserService userServiece;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private ScoresService scoresService;

	@Autowired
	private UserSubjectCoursesGoalService userSubjectCoursesGoalService;

	@RequestMapping("/student")
	public String studentHomePage(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userServiece.findByUsername(userDetails.getUsername());
		model.addAttribute("user", user);

		return "student/homeStudent";
	}

	@RequestMapping(value = "/chuan-mon-hoc/subject/{idSubject}")
	public String showInfoSubject(@PathVariable(name = "idSubject") Integer idSubject, Model model) {
		Subject subject = subjectService.findByIdSubject(idSubject);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userServiece.findByUsername(userDetails.getUsername());


		model.addAttribute("userSubjectCoursesGoal", userSubjectCoursesGoalService.findByUserAndSubject(user, subject));
		return "student/infoSubject";
	}

	@RequestMapping("/student/xem-bang-diem")
	public String xemBangDiem(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userServiece.findByUsername(userDetails.getUsername());

		model.addAttribute("scoresTable", scoresService.findByUser(user));

		return "student/scoresTableStudent";
	}

	@RequestMapping("/student/xem-chuan-dau-ra")
	public String xemChuanDauRa(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userServiece.findByUsername(userDetails.getUsername());
		model.addAttribute("listLO", user.getUserLearningoutcomeList());
		return "student/learningOutcome";
	}

	@RequestMapping("/student/xem-thong-tin-ca-nhan")
	public String xemThongTinCaNhan(Model model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", userServiece.findByUsername(userDetails.getUsername()));

		return "student/studentProfile";
	}

}
